package com.nathan22177.bidder;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import org.springframework.util.Assert;

import com.nathan22177.game.Conditions;

@Entity(name = "bidder_players")
@Embeddable
public class BidderPlayer extends AbstractBidder {
    public BidderPlayer(Conditions conditions) {
        Assert.isTrue(conditions.getQuantity() % 2 == 0 && conditions.getQuantity() > 0, "Quantity must be a positive and even number.");
        Assert.isTrue(conditions.getCash() > 0, "Cash must be positive number.");
        setConditions(conditions);
        setBalance(conditions.getCash());
    }

    /**
     * Used by JPA.
     */
    public BidderPlayer() {}
}