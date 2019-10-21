package com.nathan22177.strategies;

import com.nathan22177.bidder.BidderImpl;
import com.nathan22177.util.StrategyUtil;

/***
 * Always bids mean price of 2 QU's.
 * */
public class FairStrategy implements BiddingStrategy {

    @Override
    public int getBiddingAmount(BidderImpl bidder) {
        return StrategyUtil.getMeanPriceForOneUnit(bidder) * 2;
    }
}
