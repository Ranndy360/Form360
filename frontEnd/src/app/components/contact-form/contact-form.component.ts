import { AfterViewInit, Component, OnDestroy, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {MessageService} from 'src/app/services/message.service';
import Swal from 'sweetalert2';
declare var $: any;
@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.scss']
})
export class ContactFormComponent implements OnInit,AfterViewInit, OnDestroy {
  actualMessages: any[] = [];
  myForm = new FormGroup({
    message: new FormControl(null ?? '', [Validators.required]),
    previousMessage: new FormControl(''),
    phones: new FormControl(null ?? '', [Validators.required]),
  });

  get message() {
    return this.myForm.get('message');
  }
  get phones() {
    return this.myForm.get('phones');
  }

  constructor(
    private messageService: MessageService,
  ) {
  }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.getSendMessage();
  }

  ngOnDestroy() {
    $('#dataTable').DataTable().destroy();
  }

  async onSubmit() {
    await this.postSendMessage();
  }

  isFieldInvalid(field: FormControl) {
    return field.invalid && field.touched;
  }

  // Dentro de tu componente
  destruirDataTable() {
    const dataTable = $('#dataTable').DataTable();
    if (dataTable) {
      dataTable.destroy();
    }
  }
  
  //Send message using http service
  postSendMessage(){
    if (this.myForm.valid) {
      try {
        let message = this.message?.value || "";
        let phone = this.phones?.value || "";
        this.messageService.postSendMessage(phone,message)
        .subscribe((data: any) => {
          this.getSendMessage();
          Swal.fire('Info', 'The message to '+phone+' was send. The SID code is: '+ data.confirmationCode, 'success');
        });
      } catch (error:any) {
        Swal.fire('Info', 'Error seding the message', 'error');
        console.log('Error for dev',error);
      }
    }else
      Swal.fire('Info', 'Error seding the message', 'error');
  }


  //get all messages using http service
  getSendMessage(){
      try {
        this.messageService.getSendMessage()
        .subscribe((data: any) => {
          this.actualMessages = data;
          this.destruirDataTable();
          setTimeout(() =>{
            $('#dataTable').DataTable();
          });
        });
      } catch (error:any) {
        Swal.fire('Info', 'Error seding the message', 'error');
        console.log('Error for dev',error);
      }
  }
}
