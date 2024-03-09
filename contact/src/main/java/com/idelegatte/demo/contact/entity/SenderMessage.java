package com.idelegatte.demo.contact.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sender_message")
public class SenderMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private Message messageId;
    @Column(name = "`date`")
    private String date;
    @Column(name = "confirmation_code")
    private String confirmationCode;

}
