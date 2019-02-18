package com.superheroworld.game.logic.strategy.fight.impl;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.player.Player;
import com.superheroworld.game.logic.strategy.fight.FightStrategy;

public class BasicFightStrategy implements FightStrategy {

    @Override
    public boolean fight(Player player, Opponent opponent) {
        // let the player wins by default
        return true;
    }
}
