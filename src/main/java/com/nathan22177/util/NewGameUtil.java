package com.nathan22177.util;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Opponent;
import com.nathan22177.game.Conditions;
import com.nathan22177.game.PlayerVersusBotGame;

public class NewGameUtil {
    public static PlayerVersusBotGame createNewGameAgainstTheBot(BidderPlayer bluePlayer, Opponent opponent) {
        return new PlayerVersusBotGame(Conditions.getRandomConditions(), opponent, bluePlayer);
    }
}
