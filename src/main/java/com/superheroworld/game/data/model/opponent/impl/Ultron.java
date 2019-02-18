package com.superheroworld.game.data.model.opponent.impl;

import com.superheroworld.game.data.model.opponent.Opponent;

public class Ultron implements Opponent {

    private static final long serialVersionUID = -4706786411620318194L;
    private static Ultron INSTANCE;

    private static final String name = "Ultron";
    private static final int experience = 20;

    public String getName() {
        return name;
    }

    public int gainedExperience() {
        return experience;
    }

    public static Ultron getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Ultron();
        }
        return INSTANCE;
    }
}
