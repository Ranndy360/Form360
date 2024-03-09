package com.idelegatte.demo.contact.service;

import com.idelegatte.demo.contact.config.Helper;
import com.idelegatte.demo.contact.config.TwilioConfig;
import com.idelegatte.demo.contact.dao.MessageRepository;
import com.idelegatte.demo.contact.dao.SenderMessageRepository;
import com.idelegatte.demo.contact.entity.Message;
import com.idelegatte.demo.contact.entity.SenderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    @Autowired
    private SenderMessageRepository senderMessageRepository;
    @Autowired
    private Helper helper;
    @Autowired
    private TwilioConfig twilioConfig;

    public List<SenderMessage> findAll() {
        return senderMessageRepository.findAll();
    }

    public SenderMessage save(Message message) {
        twilioConfig.initTwilio();
        String sid = twilioConfig.sendSms(message.getTo(),message.getMessage());

        message.setDate(helper.getTodayDate());
        repository.save(message);

        SenderMessage senderMessage = new SenderMessage();
        senderMessage.setDate(helper.getTodayDate());
        senderMessage.setMessageId(message);
        senderMessage.setConfirmationCode(sid);
        return senderMessageRepository.save(senderMessage);
    }

}
