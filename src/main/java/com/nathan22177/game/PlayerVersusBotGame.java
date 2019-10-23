package com.nathan22177.game;

import com.nathan22177.bidder.BidderBot;
import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Opponent;

import lombok.Data;

@Data
public class PlayerVersusBotGame extends AbstractGame{
    BidderBot redPlayer;

    public PlayerVersusBotGame(Conditions conditions, Opponent bot, BidderPlayer bluePlayer) {
        this.conditions = conditions;
        this.redPlayer = new BidderBot(conditions, bot.getStrategy());
        this.bluePlayer = bluePlayer;
    }
}
