package com.nathan22177.strategies;

import com.nathan22177.bidder.BidderImpl;

public interface BiddingStrategy {

    int getBiddingAmount(BidderImpl bidder);

}
