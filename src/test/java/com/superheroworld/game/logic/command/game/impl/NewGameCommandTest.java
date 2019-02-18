package com.superheroworld.game.logic.command.game.impl;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.logic.command.impl.game.NewGameCommand;
import com.superheroworld.game.ui.elements.impl.BasicQuery;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NewGameCommand.class)
public class NewGameCommandTest {
    private NewGameCommand newGameCommand;
    private DefaultUserInterfaceHandler userInterfaceMock;
    private BasicQuery mockQuery;

    @Before
    public void setUp() throws Exception {
        newGameCommand = new NewGameCommand();
        mockQuery = mock(BasicQuery.class);
        userInterfaceMock = mock(DefaultUserInterfaceHandler.class);

        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceMock);
    }

    @Test
    public void testExecute() {
        String playerName = "Player_Test";
        when(mockQuery.getUserResponse()).thenReturn(playerName);
        when(userInterfaceMock.readUserInterfaceElementsFromUser())
            .thenReturn(Collections.singletonList(mockQuery));

        newGameCommand.execute();

        assertEquals(playerName, Context.getInstance().getPlayer().getName());
    }
}
