package com.superheroworld.game.data.mapper;

import com.superheroworld.game.Context;
import com.superheroworld.game.data.model.ApplicationState;

/**
 * Maps application state to Context and vice versa
 */
public class ContextApplicationStateMapper {

    /**
     * Creates Application State Object from Context
     *
     * @param context
     * @return
     */
    public static ApplicationState makeApplicationState(Context context) {

        ApplicationState.ApplicationStateBuilder applicationStateBuilder =
            new ApplicationState.ApplicationStateBuilder(context.getPlayer(),
                context.getNextCommandType(),
                context.getCommandHistory());
        applicationStateBuilder.setCurrentWorld(context.getCurrentWorld());
        applicationStateBuilder.setCurrentOpponent(context.getCurrentOpponent());

        return applicationStateBuilder.build();
    }

    /**
     * Updates a Context object with the Application State object passed
     *
     * @param context
     * @param applicationState
     */
    public static void updateContext(Context context, ApplicationState applicationState) {
        context.setPlayer(applicationState.getPlayer());
        context.setNextCommandType(applicationState.getNextCommandType());
        context.setCurrentWorld(applicationState.getCurrentWorld());
        context.setCurrentOpponent(applicationState.getCurrentOpponent());
        context.setCommandHistory(applicationState.getCommandHistory());
    }
}
