package com.nathan22177.biddingcommon.strategies;

import com.nathan22177.biddingcommon.bidder.BidderImpl;
import com.nathan22177.biddingcommon.util.StrategyUtil;

/***
 * Always bids mean price of 2 QU's.
 * */
public class FairStrategy implements BiddingStrategy {

    @Override
    public int getBiddingAmount(BidderImpl bidder) {
        return StrategyUtil.getMeanPriceForOneUnit(bidder) * 2;
    }
}
