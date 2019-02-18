package com.superheroworld.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.player.Player;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.logic.command.CommandType;

import static com.superheroworld.game.logic.command.CommandType.FIGHT;
import static com.superheroworld.game.logic.command.CommandType.LOADGAME;
import static com.superheroworld.game.logic.command.CommandType.SAVEGAME;
import static com.superheroworld.game.logic.command.CommandType.STARTGAME;
import static com.superheroworld.game.logic.command.CommandType.WELCOME;

/**
 * Holds the current context of the game
 */
public class Context implements Serializable {

    private static final long serialVersionUID = 388129809130726178L;
    private static volatile Context INSTANCE;

    private Player player;
    private World currentWorld;
    private Opponent currentOpponent;
    private Stack<CommandType> commandHistory;
    private CommandType nextCommandType;

    private Context() {
        nextCommandType = WELCOME;
        commandHistory = new Stack<>();
    }

    /**
     * returns singleton object
     *
     * @return
     */
    public static Context getInstance() {
        if (INSTANCE == null) {
            synchronized (Context.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Context();
                }
            }
        }
        return INSTANCE;
    }

    public CommandType getNextCommandType() {
        return nextCommandType;
    }

    public void setCommandHistory(Stack<CommandType> commandHistory) {
        this.commandHistory = commandHistory;
    }

    public Stack<CommandType> getCommandHistory() {
        return commandHistory;
    }

    public void setNextCommandType(CommandType nextCommandType) {
        setCommandHistory(this.nextCommandType);
        this.nextCommandType = nextCommandType;
    }

    public CommandType getPreviousCommandType() {
        if (Optional.ofNullable(commandHistory).isPresent() && !commandHistory.empty()) {
            return commandHistory.peek();
        }
        return null;
    }

    public Opponent getCurrentOpponent() {
        return currentOpponent;
    }

    public void setCurrentOpponent(Opponent currentOpponent) {
        this.currentOpponent = currentOpponent;
    }

    public World getCurrentWorld() {
        return currentWorld;
    }

    public void setCurrentWorld(World currentWorld) {
        this.currentWorld = currentWorld;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    protected Object readResolve() {
        return getInstance();
    }
//
//    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        // Loading game should update the existing context other than replacing,
//        // so as to ensure all the references are also updated
//        ois.defaultReadObject();
//        INSTANCE.player = this.player;
//        INSTANCE.currentWorld = this.currentWorld;
//        INSTANCE.currentOpponent = this.currentOpponent;
//        INSTANCE.commandHistory = this.commandHistory;
//        INSTANCE.nextCommandType = this.nextCommandType;
//    }

    private void setCommandHistory(CommandType command) {
        if (command == STARTGAME) {
            commandHistory = new Stack<>();
        } else if (!isCommandSkippedInHistory(command)) {
            commandHistory.push(command);
        }
    }

    private boolean isCommandSkippedInHistory(CommandType commandType) {
        return Arrays.asList(FIGHT, LOADGAME, WELCOME, SAVEGAME).contains(commandType);
    }
}
