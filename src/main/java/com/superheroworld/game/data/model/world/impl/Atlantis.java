package com.superheroworld.game.data.model.world.impl;

import java.util.ArrayList;
import java.util.List;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.opponent.impl.ErikKillMonger;
import com.superheroworld.game.data.model.opponent.impl.OceanMaster;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.data.model.world.WorldType;

public class Atlantis implements World {

    private static final long serialVersionUID = -1725254819926599188L;
    private List<Opponent> opponents;

    private WorldType type;

    public Atlantis() {
        type = WorldType.ATLANTIS;
        opponents = new ArrayList<>();
        opponents.add(OceanMaster.getInstance());
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
