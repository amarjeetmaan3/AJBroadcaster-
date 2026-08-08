package com.amarjeetmaan.ajbroadcaster.streaming

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Represents current streaming health metrics.
 */
data class StreamHealth(
    val uploadSpeedKbps: Double = 0.0,
    val bitrateKbps: Int = 0,
    val fps: Double = 0.0,
    val droppedFrames: Long = 0L,
    val networkQuality: String = "Unknown",
    val isHealthy: Boolean = false
)

/**
 * Monitors stream performance.
 */
@Singleton
class StreamHealthMonitor @Inject constructor() {

    private val _health =
        MutableStateFlow(
            StreamHealth()
        )

    val health: StateFlow<StreamHealth>
        get() = _health

    /**
     * Updates measured stream statistics.
     */
    fun update(
        uploadSpeedKbps: Double,
        bitrateKbps: Int,
        fps: Double,
        droppedFrames: Long
    ) {

        val quality =
            calculateNetworkQuality(
                uploadSpeedKbps = uploadSpeedKbps,
                bitrateKbps = bitrateKbps,
                droppedFrames = droppedFrames
            )

        _health.value =
            StreamHealth(
                uploadSpeedKbps =
                    uploadSpeedKbps.coerceAtLeast(0.0),
                bitrateKbps =
                    bitrateKbps.coerceAtLeast(0),
                fps =
                    fps.coerceAtLeast(0.0),
                droppedFrames =
                    droppedFrames.coerceAtLeast(0L),
                networkQuality = quality,
                isHealthy =
                    quality == "Excellent" ||
                        quality == "Good"
            )
    }

    /**
     * Resets health metrics.
     */
    fun reset() {
        _health.value = StreamHealth()
    }

    private fun calculateNetworkQuality(
        uploadSpeedKbps: Double,
        bitrateKbps: Int,
        droppedFrames: Long
    ): String {

        if (bitrateKbps <= 0) {
            return "Unknown"
        }

        if (droppedFrames > 100) {
            return "Poor"
        }

        val availableRatio =
            uploadSpeedKbps /
                bitrateKbps.toDouble()

        return when {
            availableRatio >= 2.0 -> "Excellent"
            availableRatio >= 1.3 -> "Good"
            availableRatio >= 1.0 -> "Fair"
            else -> "Poor"
        }
    }
}
