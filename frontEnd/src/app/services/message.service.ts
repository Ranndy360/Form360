import { Injectable } from '@angular/core';
import { environment } from '../enviroment/enviroment';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpEvent, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import {IGetMessagesReceiver,IGetSendMessagesReceiver, IPostMessagesSender} from '../models/http/message-service';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

    baseUrl: string = "";
    headers = new HttpHeaders();
    requestOptions: any;
    token: string = '';

  constructor(
    private http: HttpClient,
  ) {
    this.baseUrl = `${environment.API_URL}`;
 }


 /**
   * Makes an HTTP POST request to create and send message
   * @param to: phone to send the message
   *        message: message content
   * @returns all data enter in the flow
   * @responseData
   */
 public  postSendMessage(phone: string, message: string ): Observable<IPostMessagesSender>{
    const header = new HttpHeaders({
      'Content-Type': 'application/json',
    //   'Authorization': `Basic ${environment.metamap.credential}`
    });
    const body = {
      to: phone,
      message: message
    };
    return this.http.post<IGetMessagesReceiver>(`${this.baseUrl}message`,body, { headers: header });
  }


 /**
   * Makes an HTTP GET request to get all message
   * @param 
   * @returns all data enter in the flow
   * @responseData
   */
 public  getSendMessage(){
  return this.http.get<IGetMessagesReceiver>(`${this.baseUrl}message`);
}

 
}