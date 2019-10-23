package com.nathan22177.game.dto;

import java.util.List;

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
    private List<BiddingRound> biddingHistory;

    public StateDTO(PlayerVersusBotGame game) {
        BidderPlayer player = game.getBluePlayer();
        this.balance = player.getBalance();
        this.acquiredAmount = player.getBalance();
        this.biddingHistory = player.getBiddingHistory();
        this.conditions = game.getConditions();
    }
}
