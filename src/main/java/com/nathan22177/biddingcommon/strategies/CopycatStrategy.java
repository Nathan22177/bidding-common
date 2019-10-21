package com.nathan22177.biddingcommon.strategies;

import com.nathan22177.biddingcommon.bidder.BidderImpl;
import com.nathan22177.biddingcommon.util.StrategyUtil;

/***
 * Bids it's opponent's last bid plus one if has advantage, else skips round.
 * */
public class CopycatStrategy implements BiddingStrategy {

    @Override
    public int getBiddingAmount(BidderImpl bidder) {
        int defaultBid = StrategyUtil.getPreviousWinnerBid(bidder) + 1;
        if (StrategyUtil.bidderHasAdvantageOverItsOpponent(bidder)) {
            return Math.min(defaultBid, bidder.getBalance());
        } else {
            return 0;
        }
    }
}
