package com.superheroworld.game.data.model.opponent.impl;

import com.superheroworld.game.data.model.opponent.Opponent;

public class Hela implements Opponent {

    private static final long serialVersionUID = 3160987718999516432L;
    private static Hela INSTANCE;

    private static final String name = "Hela";
    private static final int experience = 50;

    public String getName() {
        return name;
    }

    public int gainedExperience() {
        return experience;
    }

    public static Hela getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Hela();
        }
        return INSTANCE;
    }
}
