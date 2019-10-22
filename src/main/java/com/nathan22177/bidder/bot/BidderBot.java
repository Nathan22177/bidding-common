package com.nathan22177.bidder.bot;

import java.util.Random;

import org.springframework.util.Assert;

import com.nathan22177.bidder.AbstractBidder;
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

    /***
    * Constructor without implicitly specified strategy.
    * */
    public BidderBot(int quantity, int cash) {
        Assert.isTrue(quantity % 2 == 0 && quantity > 0, "Quantity must be a positive and even number.");
        Assert.isTrue(cash > 0, "Cash must be positive number.");
        this.init(quantity, cash);
        this.biddingStrategy = new NathanStrategy();
    }


    public BidderBot(int quantity, int cash, BiddingStrategy strategy) {
        Assert.isTrue(quantity % 2 == 0 && quantity > 0, "Quantity must be a positive and even number.");
        Assert.isTrue(cash > 0, "Cash must be positive number.");
        this.init(quantity, cash);
        this.biddingStrategy = strategy;
    }


    public void init(int quantity, int cash) {
        setBalance(cash);
        setAcquiredAmount(0);
        setInitialQuantity(quantity);
        setInitialBalance(cash);
    }

    public int placeBid() {
        int bid = this.biddingStrategy.getBiddingAmount(this);
        Assert.isTrue(bid >= 0, "Bid should be positive number");
        Assert.isTrue(bid <= getBalance(), "Bid should not be larger than amount of MU on the balance");

        return withdraw(bid);

    }
}
