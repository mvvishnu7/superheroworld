package com.superheroworld.game.data.model.opponent.impl;

import com.superheroworld.game.data.model.opponent.Opponent;

public class OceanMaster implements Opponent {

    private static final long serialVersionUID = -2637309531940628127L;
    private static OceanMaster INSTANCE;

    private static final String name = "Ocean Master";
    private static final int experience = 10;

    public String getName() {
        return name;
    }

    public int gainedExperience() {
        return experience;
    }

    public static OceanMaster getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OceanMaster();
        }
        return INSTANCE;
    }
}
