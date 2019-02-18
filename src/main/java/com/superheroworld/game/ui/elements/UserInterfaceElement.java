package com.superheroworld.game.ui.elements;

import com.superheroworld.game.exception.IconDimensionUnCheckedException;
import com.superheroworld.game.exception.IconNotFoundUnCheckedException;
import com.superheroworld.game.exception.IconReadUnCheckedException;
import com.superheroworld.game.exception.InvalidUserInputException;

public interface UserInterfaceElement<T> {

    T getUserResponse();

    UserInterfaceType getUserInterfaceType();

    void setUserInterfaceType(UserInterfaceType userInterfaceType);

    void displayArgument(UserInterface userInterface)
        throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException;

    void handleUserResponse(String response) throws InvalidUserInputException;
}
