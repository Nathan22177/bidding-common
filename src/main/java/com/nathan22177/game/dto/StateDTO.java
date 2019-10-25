package com.nathan22177.game.dto;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.collection.BiddingRound;
import com.nathan22177.game.Conditions;
import com.nathan22177.game.PlayerVersusBotGame;

import lombok.Getter;

@Getter
public class StateDTO {
    private int balance;
    private int acquiredAmount;
    private Conditions conditions;
    private BiddingRound biddingRound;

    public StateDTO(PlayerVersusBotGame game) {
        BidderPlayer player = game.getBluePlayer();
        this.balance = player.getBalance();
        this.acquiredAmount = player.getBalance();
        this.biddingRound = player.getBiddingHistory().get(player.getBiddingHistory().size() - 1);
        this.conditions = game.getConditions();
    }
}
