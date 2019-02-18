package com.superheroworld.game.data.model.opponent.impl;

import com.superheroworld.game.data.model.opponent.Opponent;

public class Thanos implements Opponent {

    private static final long serialVersionUID = -2064669240208510776L;
    private static Thanos INSTANCE;

    private static final String name = "Thanos";
    private static final int experience = 10;

    public String getName() {
        return name;
    }

    public int gainedExperience() {
        return experience;
    }

    public static Thanos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Thanos();
        }
        return INSTANCE;
    }
}
