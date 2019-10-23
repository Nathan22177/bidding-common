package com.nathan22177.game;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Opponent;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
public class PlayerVersusPlayerGame extends AbstractGame {
    BidderPlayer redPlayer;

    public PlayerVersusPlayerGame(Conditions conditions, Opponent bot, BidderPlayer bluePlayer, BidderPlayer redPlayer) {
        this.conditions = conditions;
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        this.status = Status.JUST_STARTED;
    }
}
