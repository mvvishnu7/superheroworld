package com.superheroworld.game.data.mapper;

import com.superheroworld.game.Context;
import com.superheroworld.game.data.model.ApplicationState;

public class ContextApplicationStateMapper {

    public static ApplicationState makeApplicationState(Context context) {

        ApplicationState.ApplicationStateBuilder applicationStateBuilder =
            new ApplicationState.ApplicationStateBuilder(context.getPlayer(),
                context.getNextCommandType(),
                context.getCommandHistory());
        applicationStateBuilder.setCurrentWorld(context.getCurrentWorld());
        applicationStateBuilder.setCurrentOpponent(context.getCurrentOpponent());

        return applicationStateBuilder.build();
    }

    public static void updateContext(Context context, ApplicationState applicationState) {
        context.setPlayer(applicationState.getPlayer());
        context.setNextCommandType(applicationState.getNextCommandType());
        context.setCurrentWorld(applicationState.getCurrentWorld());
        context.setCurrentOpponent(applicationState.getCurrentOpponent());
        context.setCommandHistory(applicationState.getCommandHistory());
    }
}
