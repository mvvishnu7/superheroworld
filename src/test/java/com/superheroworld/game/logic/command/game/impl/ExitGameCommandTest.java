package com.superheroworld.game.logic.command.game.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.logic.command.impl.game.ExitGameCommand;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ExitGameCommand.class)
public class ExitGameCommandTest {


    private ExitGameCommand exitGameCommand;
    private DefaultUserInterfaceHandler userInterfaceHandlerMock;

    @Before
    public void setUp() throws Exception {
        userInterfaceHandlerMock = mock(DefaultUserInterfaceHandler.class);
        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceHandlerMock);
        exitGameCommand = new ExitGameCommand();
    }

    @Test
    public void testExecute() {
        exitGameCommand.execute();

        verify(userInterfaceHandlerMock, times(1)).printMessage(anyObject());
        assertNull(Context.getInstance().getNextCommandType());
    }
}
