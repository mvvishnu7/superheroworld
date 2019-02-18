package com.superheroworld.game.data.model.world.impl;

import java.util.ArrayList;
import java.util.List;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.opponent.impl.Hela;
import com.superheroworld.game.data.model.opponent.impl.Loki;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.data.model.world.WorldType;

public class Asgard implements World {

    private static final long serialVersionUID = 1837128910430773337L;
    private List<Opponent> opponents;
    private WorldType type;

    public Asgard() {
        type = WorldType.ASGARD;
        opponents = new ArrayList<>();
        opponents.add(Loki.getInstance());
        opponents.add(Hela.getInstance());
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
