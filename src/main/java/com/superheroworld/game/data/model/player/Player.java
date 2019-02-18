package com.superheroworld.game.data.model.player;

import java.io.Serializable;

import com.superheroworld.game.data.model.world.World;

/**
 * Represents a Player
 */
public interface Player extends Serializable {
    String getName();

    int getExperience();

    void setExperience(int experience);

    World getWorld();

    void setWorld(World world);

}
