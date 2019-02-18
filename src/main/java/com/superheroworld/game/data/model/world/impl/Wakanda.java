package com.superheroworld.game.data.model.world.impl;

import java.util.ArrayList;
import java.util.List;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.opponent.impl.ErikKillMonger;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.data.model.world.WorldType;

public class Wakanda implements World {

    private static final long serialVersionUID = -9188952096639815981L;
    private List<Opponent> opponents;
    private WorldType type;

    public Wakanda() {
        type = WorldType.WAKANDA;
        opponents = new ArrayList<>();
        opponents = new ArrayList<>();
        opponents.add(ErikKillMonger.getInstance());
    }

    @Override
    public WorldType getType() {
        return type;
    }

    @Override
    public List<Opponent> getOpponents() {
        return opponents;
    }
}
