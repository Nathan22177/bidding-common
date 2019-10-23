package com.nathan22177.game;

import java.util.UUID;

import com.nathan22177.bidder.BidderBot;
import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Opponent;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
public class PlayerVersusBotGame extends AbstractGame{
    BidderBot redPlayer;

    public PlayerVersusBotGame(Conditions conditions, Opponent bot, BidderPlayer bluePlayer) {
        this.conditions = conditions;
        this.id = UUID.randomUUID();
        this.redPlayer = new BidderBot(conditions, bot.getStrategy());
        this.bluePlayer = bluePlayer;
        this.status = Status.JUST_STARTED;
    }
}
