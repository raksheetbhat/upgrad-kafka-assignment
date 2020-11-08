package com.javadevs.gamegratificationconsumer.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@ToString
public class User {

    private final long userId;
    private final Game gameId;
    private final int level;
    private final UserRole userRole;
    private final int timeSpent;
    private final int gameCompletionPercent;

    public boolean validate() {
        return this.userId > 0 && this.userId <= 100 && this.level > 0 && this.level <= 10;
    }

}
