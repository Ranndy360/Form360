package com.idelegatte.demo.contact.config;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class Helper {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    //    @Bean
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    //    @Bean
    public void sendSms() {
        // Reemplaza "toPhoneNumber" con el número de teléfono de destino
        // y "Hello, World!" con el mensaje que deseas enviar.
        Message.creator(new com.twilio.type.PhoneNumber("+50376138735"),
                        new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                        "Hello, World!")
                .create();
    }
    public String getTodayDate(){
        LocalDate fechaActual = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaActual.format(formatter);
    }
}
