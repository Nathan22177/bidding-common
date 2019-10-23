package com.nathan22177.game;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.nathan22177.bidder.BidderPlayer;
import com.nathan22177.enums.Status;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
abstract class AbstractGame {
    @Id
    @GeneratedValue
    Long id;

    @Embedded
    BidderPlayer bluePlayer;

    @Enumerated(EnumType.STRING)
    Status status;

    // We don't ever want it to be changed after first setting it upon creation
    @Setter(AccessLevel.PRIVATE)
    @Embedded
    Conditions conditions;
}
