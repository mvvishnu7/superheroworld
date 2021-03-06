package com.superheroworld.game.logic.command.game.impl;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.logic.command.impl.game.StartGameCommand;
import com.superheroworld.game.ui.elements.Menu;
import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.impl.BasicMenu;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StartGameCommand.class)
public class StartGameCommandTest {

    private StartGameCommand startGameCommand;
    private DefaultUserInterfaceHandler userInterfaceMock;
    private Menu menuMock;
    private MenuItem menuItemMock;

    @Before
    public void setUp() throws Exception {
        startGameCommand = new StartGameCommand();
        menuMock = mock(BasicMenu.class);
        menuItemMock = mock(MenuItem.class);
        userInterfaceMock = mock(DefaultUserInterfaceHandler.class);

        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceMock);
    }

    @Test
    public void testExecute() {
        when(menuItemMock.getValue()).thenReturn(CommandType.SELECTWORLD.name());
        when(menuMock.getUserResponse()).thenReturn(menuItemMock);
        when(menuMock.getMenuItems()).thenReturn(Collections.singletonList(menuItemMock));
        when(userInterfaceMock.readUserInterfaceElementsFromUser())
            .thenReturn(Collections.singletonList(menuMock));

        startGameCommand.execute();

        assertEquals(CommandType.SELECTWORLD, Context.getInstance().getNextCommandType());
    }
}
