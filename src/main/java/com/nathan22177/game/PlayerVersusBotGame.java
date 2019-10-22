package com.nathan22177.game;

import java.util.UUID;

import com.nathan22177.bidder.bot.BidderBot;
import com.nathan22177.bidder.player.BidderPlayer;
import com.nathan22177.enums.Opponent;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
public class PlayerVersusBotGame extends AbstractGame{
    BidderBot redPlayer;

    public PlayerVersusBotGame(int quantity, int cash, Opponent bot, BidderPlayer bluePlayer) {
        setInitialQuantity(quantity);
        setInitialCash(cash);
        this.id = UUID.randomUUID();
        this.redPlayer = new BidderBot(quantity, cash, bot.getStrategy());
        this.bluePlayer = bluePlayer;
        this.status = Status.JUST_STARTED;
    }
}
