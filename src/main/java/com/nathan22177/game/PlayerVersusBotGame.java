package com.nathan22177.game;

import javax.persistence.Entity;

import com.nathan22177.bidder.BidderBot;
import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.collection.BiddingRound;
import com.nathan22177.enums.Opponent;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
@Entity
public class PlayerVersusBotGame extends AbstractGame{
    BidderBot redPlayer;

    public PlayerVersusBotGame(Conditions conditions, Opponent opponent, BidderPlayer bluePlayer) {
        this.conditions = conditions;
        this.redPlayer = new BidderBot(conditions, opponent);
        this.bluePlayer = bluePlayer;
        this.status = Status.WAITING_FOR_BIDS;
    }

    public BiddingRound playerPlacesBidVersusBot(Integer bluesBid) {
        int redsBid = getRedPlayer().getNextBid();
        resolveBidsVersusBot(bluesBid, redsBid);
        return getRedPlayer().getBiddingHistory().peekLast();
    }

    public void resolveBidsVersusBot(int bluesBid, int redsBid) {
        BidderPlayer player = getBluePlayer();
        BidderBot bot = getRedPlayer();
        player.placeBidAndWithdraw(bluesBid);
        bot.placeBidAndWithdraw(redsBid);
        player.resolveBidsAndAppendHistory(bluesBid, redsBid);
        bot.resolveBidsAndAppendHistory(redsBid, bluesBid);
        setStatus(Status.WAITING_FOR_BIDS);
    }
}
