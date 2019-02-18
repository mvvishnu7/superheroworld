package com.superheroworld.game.data.model.world;

import java.io.Serializable;
import java.util.List;

import com.superheroworld.game.data.model.opponent.Opponent;

/**
 * Represents a World
 */
public interface World extends Serializable {

    WorldType getType();

    List<Opponent> getOpponents();
}
