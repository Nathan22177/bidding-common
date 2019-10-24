package com.nathan22177.bidder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.util.Assert;

import com.nathan22177.game.Conditions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "bidder_players")
@Data
public class BidderPlayer extends AbstractBidder {

    @Embedded
    String name;

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