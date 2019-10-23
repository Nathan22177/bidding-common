package com.nathan22177.game;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.nathan22177.bidder.BidderBot;
import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.collection.BiddingRound;
import com.nathan22177.enums.Opponent;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
@Entity
public class PlayerVersusBotGame extends AbstractGame{

    @OneToOne(cascade = CascadeType.ALL)
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
        return getRedPlayer().getBiddingHistory().get(getRedPlayer().getBiddingHistory().size() - 1);
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

    /**
     * Used by JPA.
     */
    public PlayerVersusBotGame(){}
}
