package com.nathan22177.game;

import java.util.UUID;

import com.nathan22177.bidder.player.BidderPlayer;
import com.nathan22177.enums.Status;

import lombok.Data;

@Data
abstract class AbstractGame {
    UUID id;
    BidderPlayer bidderPlayer;
    Status status;
}
