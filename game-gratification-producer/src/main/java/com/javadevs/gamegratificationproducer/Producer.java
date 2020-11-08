package com.javadevs.gamegratificationproducer;

import com.javadevs.gamegratificationproducer.model.Game;
import com.javadevs.gamegratificationproducer.model.User;
import com.javadevs.gamegratificationproducer.model.UserRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import java.security.SecureRandom;

@EnableBinding(Source.class)
@RequiredArgsConstructor
@Getter
@Setter
public class Producer {
    private final Source source;
    private static final SecureRandom random = new SecureRandom();

    private static int randomNo(int bound) {
        return random.nextInt(bound) + 1;
    }

    public static User generateRandomUser() {
        return User.builder()
                .userId(randomNo(100))
                .gameId(Game.class.getEnumConstants()[random.nextInt(10)])
                .level(randomNo(10))
                .userRole(UserRole.PLAYER)
                .timeSpent(randomNo(100))
                .gameCompletionPercent(randomNo(100))
                .build();
    }

}
