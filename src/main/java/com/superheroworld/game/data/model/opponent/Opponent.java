package com.superheroworld.game.data.model.opponent;

import java.io.Serializable;

public interface Opponent extends Serializable {
    String getName();

    int gainedExperience();
}
