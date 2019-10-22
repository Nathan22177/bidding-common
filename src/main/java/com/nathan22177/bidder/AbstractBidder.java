package com.nathan22177.bidder;

import java.util.Collections;
import java.util.LinkedList;

import com.nathan22177.collection.BiddingRound;

import lombok.Data;

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
     * Initial amount of QUs.
     * */
    private int initialQuantity;

    /***
     * Initial amount of MUs.
     * */
    private int initialBalance;


    /***
     * LIFO bidding history.
     * */
    private LinkedList<BiddingRound> biddingHistory;

    protected int withdraw(int cash) {
        this.balance -= cash;
        return cash;
    }

    private void acquire(int quantity) {
        this.acquiredAmount += quantity;
    }

    public void bids(int own, int other) {
        addToBiddingHistory(own, other);
    }

    private void addToBiddingHistory(int own, int other) {
        if (getBiddingHistory() == null) {
            setBiddingHistory(new LinkedList<>(Collections.singletonList(new BiddingRound(own, other))));
        } else {
            getBiddingHistory().add(new BiddingRound(own, other));
        }

        if (other < own) {
            acquire(2);
        } else if (own == other) {
            acquire(1);
        }
    }
}
