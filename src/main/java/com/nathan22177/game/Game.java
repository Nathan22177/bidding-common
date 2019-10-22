package com.nathan22177.game;

import java.util.UUID;

import com.nathan22177.enums.GameMode;

import lombok.Data;

@Data
public class Game {
    UUID id;
    GameMode gameMode;
}
