package com.superheroworld.game.logic.command.world;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.world.World;
import com.superheroworld.game.data.model.world.WorldFactory;
import com.superheroworld.game.data.model.world.WorldType;
import com.superheroworld.game.logic.command.CommandType;
import com.superheroworld.game.logic.command.impl.game.StartGameCommand;
import com.superheroworld.game.logic.command.impl.world.SelectOpponentCommand;
import com.superheroworld.game.ui.elements.Menu;
import com.superheroworld.game.ui.elements.MenuItem;
import com.superheroworld.game.ui.elements.impl.BasicMenu;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SelectOpponentCommand.class)
public class SelectOpponentCommandTest {
    private SelectOpponentCommand selectOpponentCommand;
    private DefaultUserInterfaceHandler userInterfaceMock;
    private Menu menuMock;
    private MenuItem menuItemMock;

    @Before
    public void setUp() throws Exception {
        selectOpponentCommand = new SelectOpponentCommand();
        menuMock = mock(BasicMenu.class);
        menuItemMock = mock(MenuItem.class);
        userInterfaceMock = mock(DefaultUserInterfaceHandler.class);

        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceMock);
    }

    @Test
    public void testExecute() {
        World earth = WorldFactory.getWorld(WorldType.EARTH);
        Opponent opponent = earth.getOpponents().get(0);
        Context.getInstance().setCurrentWorld(earth);

        when(menuItemMock.getValue()).thenReturn(opponent.getName());
        when(menuMock.getUserResponse()).thenReturn(menuItemMock);
        when(menuMock.getMenuItems()).thenReturn(Collections.singletonList(menuItemMock));
        when(userInterfaceMock.readUserInterfaceElementsFromUser())
            .thenReturn(Collections.singletonList(menuMock));

        selectOpponentCommand.execute();

        assertEquals(WorldType.EARTH, Context.getInstance().getCurrentWorld().getType());
        assertEquals(opponent.getName(), Context.getInstance().getCurrentOpponent().getName());
    }
}
