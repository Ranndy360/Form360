package com.idelegatte.demo.contact.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.idelegatte.demo.contact.entity")
@EnableJpaRepositories("com.idelegatte.demo.contact.dao")
public class RoomConfig {
}
