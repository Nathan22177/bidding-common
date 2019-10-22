package com.nathan22177.game;

import com.nathan22177.bidder.bot.BidderBot;

import lombok.Data;

@Data
public class PlayerVersusBotGame extends AbstractGame{
    BidderBot redPlayer;
}
