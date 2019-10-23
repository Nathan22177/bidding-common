package com.nathan22177.game;

import com.nathan22177.bidder.BidderBot;
import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.collection.BiddingRound;
import com.nathan22177.enums.Opponent;

import lombok.Data;

@Data
public class PlayerVersusBotGame extends AbstractGame{
    BidderBot redPlayer;

    public PlayerVersusBotGame(Conditions conditions, Opponent opponent, BidderPlayer bluePlayer) {
        this.conditions = conditions;
        this.redPlayer = new BidderBot(conditions, opponent);
        this.bluePlayer = bluePlayer;
    }

    public BiddingRound playerPlacesBid(Integer bluesBid) {
        int redsBid = getRedPlayer().getNextBid();
        resolveBids(bluesBid, redsBid);
        return getRedPlayer().getBiddingHistory().peekLast();
    }

    public void resolveBids(int bluesBid, int redsBid) {
        BidderPlayer player = getBluePlayer();
        BidderBot bot = getRedPlayer();
        player.placeBidAndWithdraw(bluesBid);
        bot.placeBidAndWithdraw(redsBid);
        player.resolveBidsAndAppendHistory(bluesBid, redsBid);
        bot.resolveBidsAndAppendHistory(redsBid, bluesBid);
    }
}
