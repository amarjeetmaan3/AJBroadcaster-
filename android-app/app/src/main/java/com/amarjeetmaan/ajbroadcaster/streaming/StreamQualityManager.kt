package com.amarjeetmaan.ajbroadcaster.streaming

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Supported streaming quality profiles.
 */
enum class StreamQuality {
    LOW,
    MEDIUM,
    HIGH,
    FULL_HD
}

/**
 * Video quality configuration.
 */
data class StreamQualityProfile(
    val quality: StreamQuality,
    val resolution: String,
    val bitrateKbps: Int,
    val frameRate: Int
)

/**
 * Selects appropriate streaming quality.
 */
@Singleton
class StreamQualityManager @Inject constructor() {

    /**
     * Returns quality profile.
     */
    fun getProfile(
        quality: StreamQuality
    ): StreamQualityProfile {

        return when (quality) {

            StreamQuality.LOW ->
                StreamQualityProfile(
                    quality = quality,
                    resolution = "854x480",
                    bitrateKbps = 1200,
                    frameRate = 30
                )

            StreamQuality.MEDIUM ->
                StreamQualityProfile(
                    quality = quality,
                    resolution = "1280x720",
                    bitrateKbps = 2500,
                    frameRate = 30
                )

            StreamQuality.HIGH ->
                StreamQualityProfile(
                    quality = quality,
                    resolution = "1920x1080",
                    bitrateKbps = 4500,
                    frameRate = 30
                )

            StreamQuality.FULL_HD ->
                StreamQualityProfile(
                    quality = quality,
                    resolution = "1920x1080",
                    bitrateKbps = 6000,
                    frameRate = 60
                )
        }
    }

    /**
     * Selects a quality profile according to
     * available upload bandwidth.
     */
    fun selectForUploadSpeed(
        uploadSpeedKbps: Double
    ): StreamQualityProfile {

        return when {

            uploadSpeedKbps >= 8000.0 ->
                getProfile(
                    StreamQuality.FULL_HD
                )

            uploadSpeedKbps >= 6000.0 ->
                getProfile(
                    StreamQuality.HIGH
                )

            uploadSpeedKbps >= 3500.0 ->
                getProfile(
                    StreamQuality.MEDIUM
                )

            else ->
                getProfile(
                    StreamQuality.LOW
                )
        }
    }
}
