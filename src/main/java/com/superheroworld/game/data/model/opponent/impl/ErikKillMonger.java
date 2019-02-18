package com.superheroworld.game.data.model.opponent.impl;

import com.superheroworld.game.data.model.opponent.Opponent;

public class ErikKillMonger implements Opponent {

    private static final long serialVersionUID = 2161679267848244649L;

    private static ErikKillMonger INSTANCE;

    private static final String name = "Erik KillMonger";
    private static final int experience = 10;

    public String getName() {
        return name;
    }

    public int gainedExperience() {
        return experience;
    }

    public static ErikKillMonger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ErikKillMonger();
        }
        return INSTANCE;
    }
}
