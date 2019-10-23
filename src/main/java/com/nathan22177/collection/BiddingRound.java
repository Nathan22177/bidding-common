package com.nathan22177.collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BiddingRound {
    @Id
    Long id;

    private final int ownBid;
    private final int opponentBid;

    public BiddingRound(int own, int opponent){
        this.ownBid = own;
        this.opponentBid = opponent;
    }
}
