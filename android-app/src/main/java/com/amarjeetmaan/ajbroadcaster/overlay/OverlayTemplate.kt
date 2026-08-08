package com.amarjeetmaan.ajbroadcaster.overlay

/**
 * Reusable overlay layout definition.
 *
 * Templates do not contain cricket calculations.
 * They only describe presentation.
 */
data class OverlayTemplate(
    val id: String,
    val name: String,
    val type: String,
    val positionX: Float = 0f,
    val positionY: Float = 0f,
    val width: Float = 0f,
    val height: Float = 0f,
    val opacity: Float = 1f,
    val animation: String = "None",
    val duration: Long = 0L,
    val zIndex: Int = 0,
    val enabled: Boolean = true
)

/**
 * Standard overlay types used by AJ Broadcaster.
 */
object OverlayTypes {

    const val SCOREBOARD =
        "Scoreboard"

    const val TEAM_SCORE =
        "Team Score"

    const val BATTER =
        "Batter"

    const val BOWLER =
        "Bowler"

    const val PARTNERSHIP =
        "Partnership"

    const val REQUIRED_RUNS =
        "Required Runs"

    const val MATCH_STATUS =
        "Match Status"

    const val LOWER_THIRD =
        "Lower Third"

    const val SPONSOR =
        "Sponsor"

    const val FULL_SCREEN =
        "Full Screen"

    const val WICKET =
        "Wicket"

    const val BOUNDARY =
        "Boundary"

    const val RESULT =
        "Result"

    const val CUSTOM =
        "Custom"
}
