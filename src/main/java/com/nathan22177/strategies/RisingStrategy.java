package com.nathan22177.strategies;

import com.nathan22177.bidder.BidderImpl;
import com.nathan22177.util.StrategyUtil;

/***
* Gradually raises bid so that would go with empty balance at the end.
* */
public class RisingStrategy implements BiddingStrategy{

    @Override
    public int getBiddingAmount(BidderImpl bidder) {
        int bid = bidder.getBalance() / (StrategyUtil.getRoundsLeft(bidder) * 2) ^ 2;
    return Math.min(bid, bidder.getBalance());
    }

}
