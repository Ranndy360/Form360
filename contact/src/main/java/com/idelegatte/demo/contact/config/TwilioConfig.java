package com.idelegatte.demo.contact.config;

import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.twilio.Twilio;
import org.springframework.stereotype.Component;

@Component
public class TwilioConfig {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Bean
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

//    @Bean
    public String sendSms(String phone, String message) {
        // Reemplaza "toPhoneNumber" con el número de teléfono de destino
        // y "Hello, World!" con el mensaje que deseas enviar.
        Message messageTwi = Message.creator(new com.twilio.type.PhoneNumber(phone),
                        new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                        message)
                .create();
        return messageTwi.getSid();
    }
}
