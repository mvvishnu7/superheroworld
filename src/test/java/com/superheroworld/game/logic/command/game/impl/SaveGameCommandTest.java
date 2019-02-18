package com.superheroworld.game.logic.command.game.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.data.dao.ApplicationStateDao;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.logic.command.impl.game.SaveGameCommand;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SaveGameCommand.class)
public class SaveGameCommandTest {

    private SaveGameCommand saveGameCommand;

    private DefaultUserInterfaceHandler userInterfaceMock;

    private ApplicationStateDao daoMock;

    @Before
    public void setUp() throws Exception {
        saveGameCommand = new SaveGameCommand();
        userInterfaceMock = mock(DefaultUserInterfaceHandler.class);
        daoMock = mock(ApplicationStateDao.class);
        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceMock);
        PowerMockito.whenNew(ApplicationStateDao.class)
            .withAnyArguments().thenReturn(daoMock);
    }

    @Test
    public void testExecute() {
        saveGameCommand.execute();

        verify(userInterfaceMock, times(2)).printMessage(anyObject());
        verify(daoMock, times(1)).save(anyObject());
        Assert.assertEquals(CommandType.EXITGAME, Context.getInstance().getNextCommandType());
    }
}
