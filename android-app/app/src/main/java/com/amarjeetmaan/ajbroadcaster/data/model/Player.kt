package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a cricket player.
 *
 * This model contains player information only.
 * Performance calculations belong to the cricket engine.
 */
data class Player(

    /**
     * Unique player ID.
     */
    val id: String = "",

    /**
     * Full player name.
     */
    val fullName: String = "",

    /**
     * Nickname.
     */
    val nickName: String = "",

    /**
     * Player photo URL.
     */
    val photoUrl: String = "",

    /**
     * Jersey number.
     */
    val jerseyNumber: Int = 0,

    /**
     * Team ID.
     */
    val teamId: String = "",

    /**
     * Tournament ID.
     */
    val tournamentId: String = "",

    /**
     * Player role.
     *
     * Examples:
     * Batter
     * Bowler
     * All-Rounder
     * Wicket Keeper
     */
    val role: String = "",

    /**
     * Batting style.
     *
     * Examples:
     * Right Hand Bat
     * Left Hand Bat
     */
    val battingStyle: String = "",

    /**
     * Bowling style.
     *
     * Examples:
     * Right Arm Fast
     * Left Arm Fast
     * Right Arm Medium
     * Left Arm Medium
     * Right Arm Off Spin
     * Left Arm Orthodox
     * Leg Spin
     */
    val bowlingStyle: String = "",

    /**
     * Date of birth (Unix timestamp).
     */
    val dateOfBirth: Long = 0L,

    /**
     * Mobile number.
     */
    val phoneNumber: String = "",

    /**
     * Email address.
     */
    val email: String = "",

    /**
     * Village or city.
     */
    val location: String = "",

    /**
     * CricHeroes profile ID or URL.
     */
    val cricHeroesId: String = "",

    /**
     * Instagram profile.
     */
    val instagram: String = "",

    /**
     * Facebook profile.
     */
    val facebook: String = "",

    /**
     * Player status.
     *
     * Examples:
     * Active
     * Injured
     * Suspended
     * Unavailable
     */
    val status: String = "",

    /**
     * Created by user ID.
     */
    val createdBy: String = "",

    /**
     * Creation timestamp.
     */
    val createdAt: Long = 0L,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
