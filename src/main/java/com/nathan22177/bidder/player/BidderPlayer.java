package com.nathan22177.bidder.player;

import java.util.UUID;

import com.nathan22177.bidder.AbstractBidder;

import lombok.Data;

@Data
public class BidderPlayer extends AbstractBidder {
    UUID id;
    String name;
}