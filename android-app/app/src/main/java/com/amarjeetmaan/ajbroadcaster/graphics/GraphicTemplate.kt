package com.amarjeetmaan.ajbroadcaster.graphics

/**
 * Reusable broadcast graphic template.
 *
 * A template defines the structure of a graphic.
 * Runtime data is supplied separately by GraphicDataBinder.
 */
data class GraphicTemplate(
    val id: String,
    val name: String,
    val type: String,
    val defaultX: Float = 0f,
    val defaultY: Float = 0f,
    val defaultWidth: Float = 0f,
    val defaultHeight: Float = 0f,
    val defaultOpacity: Float = 1f,
    val defaultAnimation: String = "None",
    val defaultDuration: Long = 0L,
    val defaultZIndex: Int = 0,
    val enabled: Boolean = true
)

/**
 * Standard AJ Broadcaster graphic template types.
 */
object GraphicTemplateTypes {

    const val SCOREBOARD = "Scoreboard"
    const val BATTING_CARD = "Batting Card"
    const val BOWLING_CARD = "Bowling Card"
    const val MATCH_SUMMARY = "Match Summary"
    const val SPONSOR_BANNER = "Sponsor Banner"
    const val FALL_OF_WICKETS = "Fall Of Wickets"
    const val MANHATTAN = "Manhattan"
    const val WAGON_WHEEL = "Wagon Wheel"
    const val PLAYER_CARD = "Player Card"
    const val LOWER_THIRD = "Lower Third"
    const val BREAKING = "Breaking"
    const val CUSTOM = "Custom"
}
