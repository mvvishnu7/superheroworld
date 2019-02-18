package com.superheroworld.game.logic.command.game.impl;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.data.dao.ApplicationStateDao;
import com.superheroworld.game.data.model.ApplicationState;
import com.superheroworld.game.data.model.player.impl.DefaultPlayer;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.logic.command.impl.game.LoadGameCommand;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static com.superheroworld.game.TestUtil.getDummyApplicationState;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LoadGameCommand.class)
public class LoadGameCommandTest {
    private LoadGameCommand loadGameCommand;

    private DefaultUserInterfaceHandler userInterfaceMock;
    private ApplicationStateDao daoMock;

    @Before
    public void setUp() throws Exception {
        loadGameCommand = new LoadGameCommand();
        userInterfaceMock = mock(DefaultUserInterfaceHandler.class);
        daoMock = mock(ApplicationStateDao.class);
        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceMock);
        PowerMockito.whenNew(ApplicationStateDao.class)
            .withAnyArguments().thenReturn(daoMock);
    }

    @Test
    public void testExecute() {
        ApplicationState applicationState = getDummyApplicationState();

        when(daoMock.load()).thenReturn(applicationState);

        loadGameCommand.execute();

        verify(userInterfaceMock, times(2)).printMessage(anyObject());
        verify(daoMock, times(1)).load();

        Assert.assertEquals(CommandType.STARTGAME, Context.getInstance().getNextCommandType());
    }
}
