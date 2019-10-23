package com.nathan22177.bidder;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.util.Assert;

import com.nathan22177.collection.BiddingRound;

@Entity(name = "bidder_players")
@Embeddable
public class BidderPlayer extends AbstractBidder {
    @Id
    @GeneratedValue
    Long id;

    public void placeBidAndWithdraw(Integer bid) {
        Assert.isTrue(bid >= 0, "Bid should be positive number");
        Assert.isTrue(bid <= getBalance(), "Bid should not be larger than amount of MU on the balance");
        withdraw(bid);
    }
}