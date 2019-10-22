package com.nathan22177.collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BiddingRound {
    private final int ownBid;
    private final int opponentBid;
}
