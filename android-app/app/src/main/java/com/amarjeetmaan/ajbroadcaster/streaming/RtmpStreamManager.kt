package com.amarjeetmaan.ajbroadcaster.streaming

import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Owns the RTMP connection lifecycle.
 *
 * The actual encoder/network implementation can be connected
 * here later without changing the higher streaming layers.
 */
@Singleton
class RtmpStreamManager @Inject constructor() {

    private var config: StreamConfig? = null

    private var connected: Boolean = false

    private var bitrateKbps: Int = 0

    /**
     * Connects to the configured RTMP endpoint.
     */
    suspend fun connect(
        streamConfig: StreamConfig
    ) {

        require(
            streamConfig.rtmpUrl.isNotBlank()
        ) {
            "RTMP URL cannot be empty."
        }

        require(
            streamConfig.streamKey.isNotBlank()
        ) {
            "Stream key cannot be empty."
        }

        config = streamConfig

        bitrateKbps =
            streamConfig.videoBitrateKbps

        /*
         * Connection/encoder implementation will be
         * attached here.
         *
         * The small suspension point keeps this method
         * ready for the real asynchronous encoder.
         */
        delay(1)

        connected = true
    }

    /**
     * Disconnects from RTMP.
     */
    suspend fun disconnect() {

        if (!connected) {
            return
        }

        delay(1)

        connected = false
    }

    /**
     * Reconnects using the last configuration.
     */
    suspend fun reconnect() {

        val currentConfig =
            config
                ?: throw IllegalStateException(
                    "No previous stream configuration exists."
                )

        disconnect()

        connect(currentConfig)
    }

    /**
     * Changes video bitrate.
     */
    suspend fun setBitrate(
        bitrateKbps: Int
    ) {

        require(
            bitrateKbps > 0
        ) {
            "Bitrate must be greater than zero."
        }

        bitrateKbps.also {
            this.bitrateKbps = it
        }
    }

    /**
     * Returns whether RTMP is connected.
     */
    fun isConnected(): Boolean {
        return connected
    }

    /**
     * Returns current bitrate.
     */
    fun getBitrate(): Int {
        return bitrateKbps
    }

    /**
     * Returns current configuration.
     */
    fun getConfig(): StreamConfig? {
        return config
    }
}
