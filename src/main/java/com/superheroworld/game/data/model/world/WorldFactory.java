package com.superheroworld.game.data.model.world;

import com.superheroworld.game.data.model.world.impl.Asgard;
import com.superheroworld.game.data.model.world.impl.Atlantis;
import com.superheroworld.game.data.model.world.impl.Earth;
import com.superheroworld.game.data.model.world.impl.Wakanda;
import com.superheroworld.game.exception.InvalidWorldTypeException;

/**
 * Factory for World Object
 */
public class WorldFactory {

    /**
     * Create World Object as per World Type
     *
     * @param worldType
     * @return
     */
    public static World getWorld(WorldType worldType) {
        switch (worldType) {
            case ASGARD:
                return new Asgard();
            case ATLANTIS:
                return new Atlantis();
            case EARTH:
                return new Earth();
            case WAKANDA:
                return new Wakanda();
        }
        throw new InvalidWorldTypeException("Invalid world type -" + worldType);
    }
}
