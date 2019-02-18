package com.superheroworld.game.logic.command.opponent;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.superheroworld.game.Context;
import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.opponent.impl.Thanos;
import com.superheroworld.game.data.model.player.Player;
import com.superheroworld.game.data.model.player.impl.DefaultPlayer;
import com.superheroworld.game.logic.command.impl.opponent.FightOpponentCommand;
import com.superheroworld.game.ui.elements.impl.BasicQuery;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static com.superheroworld.game.commons.Constants.FIGHT_CHALLENGE_ACCEPTED;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FightOpponentCommand.class)
public class FightOpponentCommandTest {

    private FightOpponentCommand fightOpponentCommand;
    private DefaultUserInterfaceHandler userInterfaceMock;
    private BasicQuery mockQuery;

    @Before
    public void setUp() throws Exception {
        fightOpponentCommand = new FightOpponentCommand();
        mockQuery = mock(BasicQuery.class);
        userInterfaceMock = mock(DefaultUserInterfaceHandler.class);

        PowerMockito.whenNew(DefaultUserInterfaceHandler.class)
            .withAnyArguments().thenReturn(userInterfaceMock);
    }

    @Test
    public void testExecute() {
        when(mockQuery.getUserResponse()).thenReturn(FIGHT_CHALLENGE_ACCEPTED);
        when(userInterfaceMock.readUserInterfaceElementsFromUser())
            .thenReturn(Collections.singletonList(mockQuery));

        Player player = new DefaultPlayer("TEST_PLAYER");
        Opponent opponent = new Thanos();
        Context currentContext = Context.getInstance();
        currentContext.setPlayer(player);
        currentContext.setCurrentOpponent(opponent);

        fightOpponentCommand.execute();

        assertEquals(player.getExperience(), opponent.gainedExperience());
    }
}
