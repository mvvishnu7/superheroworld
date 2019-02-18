package com.superheroworld.game.data.model;

import java.io.Serializable;
import java.util.Stack;

import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.player.Player;
import com.superheroworld.game.data.model.world.World;

public class ApplicationState implements Serializable {
    private Player player;
    private World currentWorld;
    private Opponent currentOpponent;
    private CommandType nextCommandType;
    private Stack<CommandType> commandHistory;

    private ApplicationState(ApplicationStateBuilder builder) {
        this.currentOpponent = builder.currentOpponent;
        this.currentWorld = builder.currentWorld;
        this.nextCommandType = builder.nextCommandType;
        this.player = builder.player;
        this.commandHistory = builder.commandHistory;
    }

    public Stack<CommandType> getCommandHistory() {
        return commandHistory;
    }

    public Player getPlayer() {
        return player;
    }

    public World getCurrentWorld() {
        return currentWorld;
    }

    public Opponent getCurrentOpponent() {
        return currentOpponent;
    }

    public CommandType getNextCommandType() {
        return nextCommandType;
    }

    public static class ApplicationStateBuilder {
        // Required Parameters
        private Player player;
        private CommandType nextCommandType;
        private Stack<CommandType> commandHistory;

        // Optional Parameters
        private World currentWorld;
        private Opponent currentOpponent;

        public ApplicationStateBuilder(Player player
            , CommandType nextCommandType
            , Stack<CommandType> commandHistory) {
            this.player = player;
            this.nextCommandType = nextCommandType;
            this.commandHistory = commandHistory;
        }

        public void setCurrentWorld(World currentWorld) {
            this.currentWorld = currentWorld;
        }

        public void setCurrentOpponent(Opponent currentOpponent) {
            this.currentOpponent = currentOpponent;
        }

        public ApplicationState build() {
            return new ApplicationState(this);
        }
    }
}
