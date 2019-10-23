package com.nathan22177.game;

import org.springframework.util.Assert;

import com.nathan22177.bidder.BidderBot;
import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.collection.BiddingRound;
import com.nathan22177.enums.Opponent;

import lombok.Data;

@Data
public class PlayerVersusBotGame extends AbstractGame{
    BidderBot redPlayer;

    public PlayerVersusBotGame(Conditions conditions, Opponent bot, BidderPlayer bluePlayer) {
        this.conditions = conditions;
        this.redPlayer = new BidderBot(conditions, bot.getStrategy());
        this.bluePlayer = bluePlayer;
    }

    public BiddingRound playerPlacesBid(Integer bluesBid) {
        BidderPlayer player = getBluePlayer();
        BidderBot bot = getRedPlayer();
        player.placeBidAndWithdraw(bluesBid);
        int redsBid = bot.placeBidAndWithdraw();
        player.resolveBidsAndAppendHistory(bluesBid, redsBid);
        bot.resolveBidsAndAppendHistory(redsBid, bluesBid);
        return player.getBiddingHistory().peekLast();
    }
}
