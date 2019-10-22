package com.nathan22177.game;

import java.util.UUID;

import com.nathan22177.bidder.player.BidderPlayer;
import com.nathan22177.enums.Opponent;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
public class PlayerVersusPlayerGame extends AbstractGame {
    BidderPlayer redPlayer;

    public PlayerVersusPlayerGame(int quantity, int cash, Opponent bot, BidderPlayer bluePlayer, BidderPlayer redPlayer) {
        setInitialQuantity(quantity);
        setInitialCash(cash);
        this.id = UUID.randomUUID();
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        this.status = Status.JUST_STARTED;
    }
}
