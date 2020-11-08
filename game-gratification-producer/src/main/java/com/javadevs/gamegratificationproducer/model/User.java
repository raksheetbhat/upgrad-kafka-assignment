package com.javadevs.gamegratificationproducer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class User {

    private long userId;
    private Game gameId;
    private int level;
    private UserRole userRole;
    private int timeSpent;
    private int gameCompletionPercent;

    public boolean validate() {
        return this.userId > 0 && this.userId <= 100 && this.level > 0 && this.level <= 10;
    }

}
