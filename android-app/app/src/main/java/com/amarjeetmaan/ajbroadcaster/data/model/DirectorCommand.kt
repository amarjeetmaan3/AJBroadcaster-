package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a command sent from the Director Panel
 * to control broadcasting features.
 */
data class DirectorCommand(

    /**
     * Unique command ID.
     */
    val id: String = "",

    /**
     * Match ID.
     */
    val matchId: String = "",

    /**
     * Command type.
     *
     * Examples:
     * ShowScoreboard
     * HideScoreboard
     * ShowBattingCard
     * ShowBowlingCard
     * ShowMatchSummary
     * PlayFourAnimation
     * PlaySixAnimation
     * PlayWicketAnimation
     * ShowSponsorBanner
     * HideOverlay
     * SwitchCamera
     * StartReplay
     * StopReplay
     */
    val command: String = "",

    /**
     * Optional command value.
     */
    val value: String = "",

    /**
     * Target module.
     *
     * Examples:
     * Graphics
     * Camera
     * Streaming
     * Replay
     */
    val target: String = "",

    /**
     * Priority level.
     */
    val priority: Int = 0,

    /**
     * Whether the command has been executed.
     */
    val executed: Boolean = false,

    /**
     * User ID who issued the command.
     */
    val issuedBy: String = "",

    /**
     * Command timestamp.
     */
    val timestamp: Long = 0L
)
