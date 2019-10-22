package com.nathan22177.strategies;

import com.nathan22177.bidder.bot.BidderBot;

public interface BiddingStrategy {

    int getBiddingAmount(BidderBot bidder);

}
