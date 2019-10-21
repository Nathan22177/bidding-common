package com.nathan22177.biddingcommon.strategies;

import com.nathan22177.biddingcommon.bidder.BidderImpl;
import com.nathan22177.biddingcommon.strategies.BiddingStrategy;
import com.nathan22177.biddingcommon.util.StrategyUtil;

/***
 * Waits for an advantage then bids last winning bid plus one;
 * */
public class WinnerIncrementStrategy implements BiddingStrategy {

    private int calculateBiddingAmount(BidderImpl bidder) {
        if (StrategyUtil.bidderHasAdvantageOverItsOpponent(bidder)) {
            return StrategyUtil.getPreviousWinnerBid(bidder) + 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getBiddingAmount(BidderImpl bidder) {
        int bid = calculateBiddingAmount(bidder);
        return bid >= 0 && bid <= bidder.getBalance()
                ? bid
                : 0;
    }
}
