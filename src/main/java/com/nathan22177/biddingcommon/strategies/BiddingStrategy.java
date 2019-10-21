package com.nathan22177.biddingcommon.strategies;

import com.nathan22177.biddingcommon.bidder.BidderImpl;

public interface BiddingStrategy {

    int getBiddingAmount(BidderImpl bidder);

}
