package com.nathan22177.bidder;

import java.util.Random;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.util.Assert;

import com.nathan22177.enums.Opponent;
import com.nathan22177.game.Conditions;
import com.nathan22177.strategies.BiddingStrategy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@Entity(name = "bidder_bots")
public class BidderBot extends AbstractBidder {

    /***
     * Strategy that defines how to bid.
     * */
    @Transient
    private BiddingStrategy biddingStrategy;
    @Embedded
    private String title;

    private final Random random = new Random();


    public BidderBot(Conditions conditions, Opponent opponent) {
        Assert.isTrue(conditions.getQuantity() % 2 == 0 && conditions.getQuantity() > 0, "Quantity must be a positive and even number.");
        Assert.isTrue(conditions.getCash() > 0, "Cash must be positive number.");
        setConditions(conditions);
        setBalance(conditions.getCash());
        this.biddingStrategy = opponent.getStrategy();
        this.title = opponent.getTitle();
    }


    public int getNextBid() {
        return this.biddingStrategy.getBiddingAmount(this);
    }

    /**
     * Used by JPA.
     */
    public BidderBot(){}
}
