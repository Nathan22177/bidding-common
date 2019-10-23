package com.nathan22177.bidder;

import java.util.Collections;
import java.util.LinkedList;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.nathan22177.collection.BiddingRound;
import com.nathan22177.game.Conditions;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
public abstract class AbstractBidder {
    /***
     * Amount of cash left.
     * */
    private int balance;

    /***
     * Amount of won QUs.
     * */
    private int acquiredAmount;

    /***
     * Initial cash and QU
     * */
    @Setter(AccessLevel.PACKAGE)
    @Embedded
    private Conditions conditions;


    /***
     * LIFO bidding history.
     * */
    @ElementCollection
    private LinkedList<BiddingRound> biddingHistory;

    protected void withdraw(int cash) {
        this.balance -= cash;
    }

    private void acquire(int quantity) {
        this.acquiredAmount += quantity;
    }

    public void resolveBidsAndAppendHistory(int own, int other) {
        appendBiddingHistory(own, other);
        resolveBids(own, other);
    }

    private void appendBiddingHistory(int own, int other) {
        if (getBiddingHistory() == null) {
            setBiddingHistory(new LinkedList<>(Collections.singletonList(new BiddingRound(own, other))));
        } else {
            getBiddingHistory().add(new BiddingRound(own, other));
        }
    }

    private void resolveBids(int own, int other) {
        if (other < own) {
            acquire(2);
        } else if (own == other) {
            acquire(1);
        }
    }
}
