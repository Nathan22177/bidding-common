package com.nathan22177.bidder;

import java.util.Random;

import org.springframework.util.Assert;

import com.nathan22177.bidder.AbstractBidder;
import com.nathan22177.game.Conditions;
import com.nathan22177.strategies.BiddingStrategy;
import com.nathan22177.strategies.NathanStrategy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class BidderBot extends AbstractBidder {

    /***
     * Strategy that defines how to bid.
     * */
    private BiddingStrategy biddingStrategy;

    private final Random random = new Random();


    public BidderBot(Conditions conditions, BiddingStrategy strategy) {
        Assert.isTrue(conditions.getQuantity() % 2 == 0 && conditions.getQuantity() > 0, "Quantity must be a positive and even number.");
        Assert.isTrue(conditions.getCash() > 0, "Cash must be positive number.");
        setConditions(conditions);
        setBalance(conditions.getCash());
        this.biddingStrategy = strategy;
    }



    public int placeBid() {
        int bid = this.biddingStrategy.getBiddingAmount(this);
        Assert.isTrue(bid >= 0, "Bid should be positive number");
        Assert.isTrue(bid <= getBalance(), "Bid should not be larger than amount of MU on the balance");

        return withdraw(bid);

    }
}
