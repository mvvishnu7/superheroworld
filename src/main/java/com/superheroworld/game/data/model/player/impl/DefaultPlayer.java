package com.superheroworld.game.data.model.player.impl;


import com.superheroworld.game.data.model.player.Player;
import com.superheroworld.game.data.model.world.World;

public class DefaultPlayer implements Player {

    private static final long serialVersionUID = 8073179447443098582L;
    private String name;
    private int experience;
    private World world;

    public DefaultPlayer(String name) {
        this.name = name;
        this.experience = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }
}
