package com.nathan22177.game;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.nathan22177.bidder.BidderBot;
import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.collection.BiddingRound;
import com.nathan22177.enums.Opponent;
import com.nathan22177.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PlayerVersusBotGame extends AbstractGame{

    @OneToOne(cascade = CascadeType.ALL)
    BidderBot redPlayer;

    public PlayerVersusBotGame(Conditions conditions, Opponent opponent) {
        this.conditions = conditions;
        this.redPlayer = new BidderBot(conditions, opponent);
        this.bluePlayer = new BidderPlayer(conditions);
        this.status = Status.WAITING_FOR_BIDS;
    }

    public BiddingRound playerPlacesBidVersusBot(Integer bluesBid) {
        int redsBid = getRedPlayer().getNextBid();
        resolveBidsVersusBot(bluesBid, redsBid);
        if (theGameHasEnded()){
            resolveGamesEnd();
        }
        return getRedPlayer().getBiddingHistory().get(getRedPlayer().getBiddingHistory().size() - 1);
    }

    public boolean theGameHasEnded() {
        return getRedPlayer().getAcquiredAmount() + getBluePlayer().getAcquiredAmount() == getConditions().getQuantity();
    }

    void resolveGamesEnd() {
        if (redHasMoreQuantity()) {
            setStatus(Status.RED_WON);
        } else if (blueHasMoreQuantity()) {
            setStatus(Status.BLUE_WON);
        } else {
            resolveDraw();
        }
    }

    void resolveDraw() {
        if (redHasMoreCash()) {
            setStatus(Status.RED_WON);
        } else if (blueHasMoreCash()) {
            setStatus(Status.BLUE_WON);
        } else {
            setStatus(Status.DRAW);
        }
    }

    boolean redHasMoreQuantity() {
        return getRedPlayer().getAcquiredAmount() > getBluePlayer().getAcquiredAmount();
    }

    boolean blueHasMoreQuantity() {
        return getRedPlayer().getAcquiredAmount() < getBluePlayer().getAcquiredAmount();
    }

    boolean redHasMoreCash() {
        return getRedPlayer().getBalance() > getBluePlayer().getBalance();
    }

    boolean blueHasMoreCash() {
        return getRedPlayer().getBalance() < getBluePlayer().getBalance();
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
