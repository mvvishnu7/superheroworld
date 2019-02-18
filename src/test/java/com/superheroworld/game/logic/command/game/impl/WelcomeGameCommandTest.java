package com.superheroworld.game.logic.command.game.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.logic.command.impl.game.WelcomeGameCommand;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(WelcomeGameCommand.class)
public class WelcomeGameCommandTest {
    private WelcomeGameCommand welcomeGameCommand;

    private DefaultUserInterfaceHandler userInterfaceMock;

    @Before
    public void setUp() throws Exception {
        welcomeGameCommand = new WelcomeGameCommand();
        userInterfaceMock = mock(DefaultUserInterfaceHandler.class);

        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceMock);
    }

    @Test
    public void testExecute() {
        welcomeGameCommand.execute();

        verify(userInterfaceMock, times(1)).printIconHorizontally(anyObject(), anyInt());
        Assert.assertEquals(CommandType.STARTGAME, Context.getInstance().getNextCommandType());
    }
}
