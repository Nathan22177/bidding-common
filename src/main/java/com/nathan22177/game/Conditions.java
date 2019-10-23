package com.nathan22177.game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Opponent;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Conditions {
    private final static List<Integer> cashPoll = Arrays.asList(1000, 5000, 20_000, 80_000);
    private final static List<Integer> quantityPoll = Arrays.asList(8, 16, 20);
    private final static Random rand = new Random();

    private int quantity;
    private int cash;

    public static Conditions getRandomConditions() {
        return new Conditions(getRandomCondition(quantityPoll), getRandomCondition(quantityPoll));
    }

    private static Integer getRandomCondition(List<Integer> poll) {
        return poll.get(rand.nextInt(poll.size()));
    }
}
