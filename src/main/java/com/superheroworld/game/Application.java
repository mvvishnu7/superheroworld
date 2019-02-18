package com.superheroworld.game;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.superheroworld.game.logic.command.CommandInvoker;
import com.superheroworld.game.logic.command.CommandType;

import static com.superheroworld.game.logic.command.CommandType.EXITGAME;

/**
 * The class is the entry point for game and controls the overall execution of the game
 */
public class Application {
    private static Logger LOG;

    static {
        setLoggerProperties();
        //must initialize loggers after setting above property
        LOG = Logger.getLogger(Application.class.getName());
    }

    private Context context;

    private Application() {
        context = Context.getInstance();
        setLoggerProperties();
    }

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        LOG.log(Level.INFO, "Starting Application...");
        do {
            if (Optional.ofNullable(context.getNextCommandType()).isPresent()) {
                CommandType commandType = context.getNextCommandType();
                LOG.log(Level.INFO, "Starting executing command - " + commandType);
                CommandInvoker.executeCommand(commandType);
                LOG.log(Level.INFO, "Completed executing command - " + commandType);
            } else {
                break;
            }
        } while (context.getPreviousCommandType() != EXITGAME || context.getNextCommandType() != null);
        LOG.log(Level.INFO, "Exiting Application...");
    }

    /**
     * Sets logging properties file location.
     * Can be set via command in future while running
     */
    private static void setLoggerProperties() {
        // The variable is set her for demo purpose
        System.setProperty("java.util.logging.config.file",
            "src/main/resources/logging.properties");
    }
}
