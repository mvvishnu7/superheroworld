package com.superheroworld.game.ui.elements;

import java.util.List;

import com.superheroworld.game.exception.IconDimensionUnCheckedException;
import com.superheroworld.game.exception.IconNotFoundUnCheckedException;
import com.superheroworld.game.exception.IconReadUnCheckedException;

/**
 * Interface to handle User interactions
 */
public interface UserInterface {

    /**
     * Prints a message
     *
     * @param messages
     */
    void printMessage(List<String> messages);

    /**
     * Sets the various user interface elements
     *
     * @param userInterfaceElements
     */
    void setUserUserInterfaceElements(List<UserInterfaceElement> userInterfaceElements);

    /**
     * Reads response for all the user interface elements present
     *
     * @return
     * @throws IconDimensionUnCheckedException
     * @throws IconNotFoundUnCheckedException
     * @throws IconReadUnCheckedException
     */
    List<UserInterfaceElement> readUserInterfaceElementsFromUser()
        throws IconDimensionUnCheckedException,
        IconNotFoundUnCheckedException, IconReadUnCheckedException;

    /**
     * Prints the icons horizontally
     *
     * @param icons
     * @param iconsPerColumn
     * @throws IconDimensionUnCheckedException
     * @throws IconNotFoundUnCheckedException
     * @throws IconReadUnCheckedException
     */
    void printIconHorizontally(List<IconInfo> icons)
        throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException;
}
