package com.nathan22177.game;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Status;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
abstract class AbstractGame {
    @Id
    @GeneratedValue
    Long id;
    BidderPlayer bluePlayer;
    Status status;

    // We don't ever want it to be changed after first setting it upon creation
    @Setter(AccessLevel.PRIVATE)
    Conditions conditions;
}
