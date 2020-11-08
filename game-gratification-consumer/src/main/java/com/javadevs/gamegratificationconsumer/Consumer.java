package com.javadevs.gamegratificationconsumer;

import com.javadevs.gamegratificationconsumer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
@Slf4j
public class Consumer {

    @StreamListener(target = Sink.INPUT)
    public void consume(@Payload User user) {
        log.info("received message: {}", user.toString());
    }

}
