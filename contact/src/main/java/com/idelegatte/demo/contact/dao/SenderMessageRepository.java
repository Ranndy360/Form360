package com.idelegatte.demo.contact.dao;


import com.idelegatte.demo.contact.entity.SenderMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderMessageRepository extends JpaRepository<SenderMessage, Long> {
}

