package com.superheroworld.game.data.model.world.impl;

import java.util.ArrayList;
import java.util.List;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.opponent.impl.Thanos;
import com.superheroworld.game.data.model.opponent.impl.Ultron;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.data.model.world.WorldType;

public class Earth implements World {

    private static final long serialVersionUID = 583462715912673550L;
    private WorldType type;
    private List<Opponent> opponents;

    public Earth() {
        type = WorldType.EARTH;
        opponents = new ArrayList<>();
        opponents.add(Thanos.getInstance());
        opponents.add(Ultron.getInstance());
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
