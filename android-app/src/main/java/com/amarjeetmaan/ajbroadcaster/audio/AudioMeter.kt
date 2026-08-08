package com.amarjeetmaan.ajbroadcaster.audio

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.sqrt

data class AudioLevel(
    val rms: Float,
    val peak: Float,
    val decibels: Float
)

class AudioMeter {

    fun measure(
        samples: FloatArray
    ): AudioLevel {

        if (samples.isEmpty()) {
            return AudioLevel(
                rms = 0f,
                peak = 0f,
                decibels = -120f
            )
        }

        var sumSquares = 0.0
        var peak = 0f

        for (sample in samples) {

            val absolute =
                abs(sample)

            sumSquares +=
                sample.toDouble() *
                    sample.toDouble()

            if (absolute > peak) {
                peak = absolute
            }
        }

        val rms =
            sqrt(
                sumSquares /
                    samples.size
            ).toFloat()
                .coerceIn(
                    0f,
                    1f
                )

        val decibels =
            if (rms <= 0f) {
                -120f
            } else {
                (
                    20.0 *
                        log10(
                            rms.toDouble()
                        )
                    ).toFloat()
            }

        return AudioLevel(
            rms = rms,
            peak = peak.coerceIn(
                0f,
                1f
            ),
            decibels = decibels.coerceAtLeast(
                -120f
            )
        )
    }
}
