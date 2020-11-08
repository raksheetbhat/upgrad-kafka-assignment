package com.javadevs.gamegratificationproducer;

import com.javadevs.gamegratificationproducer.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class GameGratificationProducerApplication {
    private final Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(GameGratificationProducerApplication.class, args);
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduleKafkaEvents() {
        //generate a random event every X seconds
        User randomUser = Producer.generateRandomUser();

        log.info("user generated: {}", randomUser.toString());

        if (!randomUser.validate())
            throw new InvalidUserException("User is invalid");

        producer.getSource()
                .output()
                .send(MessageBuilder.withPayload(randomUser).build());
    }

}
