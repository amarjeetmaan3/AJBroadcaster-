package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball

/**
 * Handles all recognised cricket extras.
 */
class ExtrasManager {

    enum class ExtraType {
        NONE,
        WIDE,
        NO_BALL,
        BYE,
        LEG_BYE,
        PENALTY
    }

    fun normalize(
        type: String
    ): ExtraType {
        return when (type.trim().lowercase()) {
            "wide" -> ExtraType.WIDE
            "no ball",
            "noball",
            "no-ball" -> ExtraType.NO_BALL
            "bye" -> ExtraType.BYE
            "leg bye",
            "legbye",
            "leg-bye" -> ExtraType.LEG_BYE
            "penalty",
            "penalty runs" -> ExtraType.PENALTY
            else -> ExtraType.NONE
        }
    }

    fun totalExtras(
        balls: List<Ball>
    ): Int {
        return balls.sumOf {
            it.extras.coerceAtLeast(0)
        }
    }

    fun totalByType(
        balls: List<Ball>,
        type: ExtraType
    ): Int {
        return balls
            .filter {
                normalize(it.extraType) == type
            }
            .sumOf {
                it.extras.coerceAtLeast(0)
            }
    }

    fun isExtraDelivery(
        ball: Ball
    ): Boolean {
        return normalize(ball.extraType) !=
            ExtraType.NONE
    }

    fun isLegalDelivery(
        ball: Ball
    ): Boolean {
        return when (normalize(ball.extraType)) {
            ExtraType.WIDE -> false
            ExtraType.NO_BALL -> false
            else -> true
        }
    }
}
