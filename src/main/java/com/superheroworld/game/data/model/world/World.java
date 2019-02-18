package com.superheroworld.game.data.model.world;

import java.io.Serializable;
import java.util.List;

import com.superheroworld.game.data.model.opponent.Opponent;

public interface World extends Serializable {

    WorldType getType();

    List<Opponent> getOpponents();
}
