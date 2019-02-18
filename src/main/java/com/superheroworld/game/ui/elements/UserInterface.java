package com.superheroworld.game.ui.elements;

import java.util.List;

import com.superheroworld.game.exception.IconDimensionUnCheckedException;
import com.superheroworld.game.exception.IconNotFoundUnCheckedException;
import com.superheroworld.game.exception.IconReadUnCheckedException;

public interface UserInterface {

    void printMessage(List<String> messages);

    void setUserUserInterfaceElements(List<UserInterfaceElement> userInterfaceElements);

    List<UserInterfaceElement> readUserInterfaceElementsFromUser()
        throws IconDimensionUnCheckedException,
        IconNotFoundUnCheckedException, IconReadUnCheckedException;

    void printIconHorizontally(List<IconInfo> icons, int iconsPerColumn)
        throws IconDimensionUnCheckedException, IconNotFoundUnCheckedException, IconReadUnCheckedException;
}
