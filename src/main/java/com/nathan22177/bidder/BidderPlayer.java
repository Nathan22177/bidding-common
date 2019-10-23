package com.nathan22177.bidder;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "bidder_players")
@Embeddable
public class BidderPlayer extends AbstractBidder {
    @Id
    @GeneratedValue
    Long id;
}