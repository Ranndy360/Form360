package com.idelegatte.demo.contact.dao;

import com.idelegatte.demo.contact.entity.Message;
import com.idelegatte.demo.contact.entity.SenderMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
