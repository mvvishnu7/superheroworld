package com.superheroworld.game.logic.strategy.fight;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.player.Player;

public interface FightStrategy {
    boolean fight(Player player, Opponent opponent);
}
