package com.superheroworld.game.data.model.opponent.impl;

import com.superheroworld.game.data.model.opponent.Opponent;

public class Loki implements Opponent {

    private static final long serialVersionUID = 8498553477296973416L;
    private static Loki INSTANCE;

    private static final String name = "Loki";
    private static final int experience = 10;

    public String getName() {
        return name;
    }

    public int gainedExperience() {
        return experience;
    }

    public static Loki getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Loki();
        }
        return INSTANCE;
    }
}
