package com.nathan22177.collection;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BiddingRound {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private final int ownBid;
    private final int opponentBid;

    public BiddingRound(int own, int opponent){
        this.ownBid = own;
        this.opponentBid = opponent;
    }
}
