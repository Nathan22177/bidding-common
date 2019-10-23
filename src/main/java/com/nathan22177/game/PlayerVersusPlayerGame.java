package com.nathan22177.game;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
@Entity
public class PlayerVersusPlayerGame extends AbstractGame {

    @Embedded
    BidderPlayer redPlayer;

    public PlayerVersusPlayerGame(Conditions conditions, BidderPlayer bluePlayer) {
        this.conditions = conditions;
        this.bluePlayer = bluePlayer;
    }
}
