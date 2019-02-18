package com.superheroworld.game.data.model.opponent;

import java.io.Serializable;

/**
 * Interface to represent Opponents
 */
public interface Opponent extends Serializable {
    String getName();

    int gainedExperience();
}
