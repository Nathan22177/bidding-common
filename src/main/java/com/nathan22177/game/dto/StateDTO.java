package com.nathan22177.game.dto;

import java.util.List;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.collection.BiddingRound;

public class StateDTO {
    private int balance;
    private int acquiredAmount;
    private List<BiddingRound> biddingHistory;

    public StateDTO(BidderPlayer player) {
        this.balance = player.getBalance();
        this.acquiredAmount = player.getBalance();
        this.biddingHistory = player.getBiddingHistory();
    }
}
