package com.superheroworld.game.logic.command.impl.opponent;

import java.util.Arrays;
import java.util.Collections;

import com.superheroworld.game.data.model.opponent.Opponent;
import com.superheroworld.game.data.model.player.Player;
import com.superheroworld.game.logic.command.AbstractCommand;
import com.superheroworld.game.logic.strategy.fight.FightStrategy;
import com.superheroworld.game.logic.strategy.fight.impl.BasicFightStrategy;
import com.superheroworld.game.ui.elements.IconInfo;
import com.superheroworld.game.ui.elements.UserInterface;
import com.superheroworld.game.ui.elements.impl.BasicQuery;
import com.superheroworld.game.ui.elements.impl.DefaultUserInterfaceHandler;

import static com.superheroworld.game.commons.Constants.FIGHT_CHALLENGE_ACCEPTED;
import static com.superheroworld.game.commons.Constants.FIGHT_CHALLENGE_REJECTED;
import static com.superheroworld.game.commons.Constants.MENU_ITEM_ENTER_KEY;
import static com.superheroworld.game.commons.Constants.PAGE_SEPARATOR;
import static com.superheroworld.game.logic.command.CommandType.FIGHT;
import static com.superheroworld.game.logic.command.CommandType.SELECTOPPONENTS;
import static com.superheroworld.game.ui.util.IconUtil.getIconRelativePath;

public class FightOpponentCommand extends AbstractCommand {

    //    TODO check on opponent strategy
    public FightOpponentCommand() {
        super(FIGHT);
    }

    @Override
    public void execute() {
        Opponent opponent = getContext().getCurrentOpponent();
        BasicQuery query = new BasicQuery();

        UserInterface userInterface = new DefaultUserInterfaceHandler();
        userInterface.printMessage(Arrays.asList(
            "Do you want to opponent " + opponent.getName(),
            MENU_ITEM_ENTER_KEY + " "
                + FIGHT_CHALLENGE_ACCEPTED
                + " or " + FIGHT_CHALLENGE_REJECTED + ": "));
        userInterface.setUserUserInterfaceElements(Collections.singletonList(query));
        String challengeResponse = (String) userInterface
            .readUserInterfaceElementsFromUser()
            .get(0)
            .getUserResponse();

        if (challengeResponse.equalsIgnoreCase(FIGHT_CHALLENGE_ACCEPTED)) {
            Player player = getContext().getPlayer();
            int playerCurrentExperience = player.getExperience();

            // Fight as per strategy
            FightStrategy fightStrategy = new BasicFightStrategy();
            if (fightStrategy.fight(player, opponent)) {
                player.setExperience(playerCurrentExperience + opponent.gainedExperience());
            }

            String fightIconPath = getIconRelativePath("won_fight.txt");
            IconInfo iconInfo = new IconInfo();
            iconInfo.setLabel("Your experience --> " + player.getExperience() + "\n");
            iconInfo.setRelativePath(fightIconPath);
            userInterface.printIconHorizontally(Collections.singletonList(iconInfo));

            getContext().setNextCommandType(SELECTOPPONENTS);
            userInterface.printMessage(Collections.singletonList(PAGE_SEPARATOR));
        } else {
            getContext().setNextCommandType(SELECTOPPONENTS);
        }
    }
}
