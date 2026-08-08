package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball

/**
 * Handles dismissal validation and wicket statistics.
 */
class WicketManager {

    enum class WicketType {
        BOWLED,
        CAUGHT,
        LBW,
        RUN_OUT,
        STUMPED,
        HIT_WICKET,
        RETIRED_OUT,
        TIMED_OUT,
        OBSTRUCTING_FIELD,
        UNKNOWN
    }

    fun normalize(
        type: String
    ): WicketType {
        return when (type.trim().lowercase()) {
            "bowled" -> WicketType.BOWLED
            "caught",
            "catch" -> WicketType.CAUGHT
            "lbw" -> WicketType.LBW
            "run out",
            "runout" -> WicketType.RUN_OUT
            "stumped",
            "stumping" -> WicketType.STUMPED
            "hit wicket" -> WicketType.HIT_WICKET
            "retired out" -> WicketType.RETIRED_OUT
            "timed out" -> WicketType.TIMED_OUT
            "obstructing the field",
            "obstructing field" ->
                WicketType.OBSTRUCTING_FIELD

            else -> WicketType.UNKNOWN
        }
    }

    fun isWicket(
        ball: Ball
    ): Boolean {
        return ball.isWicket
    }

    fun isBowlerCredited(
        wicketType: String
    ): Boolean {
        return when (normalize(wicketType)) {
            WicketType.BOWLED,
            WicketType.CAUGHT,
            WicketType.LBW,
            WicketType.STUMPED,
            WicketType.HIT_WICKET -> true

            else -> false
        }
    }

    fun countWickets(
        balls: List<Ball>
    ): Int {
        return balls.count { it.isWicket }
    }
}
