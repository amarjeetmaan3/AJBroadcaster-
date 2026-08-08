package com.amarjeetmaan.ajbroadcaster.streaming

/**
 * RTMP connection contract.
 *
 * The real RTMP/RTMPS transport implementation belongs
 * in the Android/network streaming layer.
 */
class RtmpConnection : StreamConnection {

    private var config: StreamingConfig? = null
    private var connected = false

    override fun configure(
        config: StreamingConfig
    ): Result<Unit> {

        if (
            config.protocol != StreamingProtocol.RTMP &&
            config.protocol != StreamingProtocol.RTMPS
        ) {
            return Result.failure(
                IllegalArgumentException(
                    "RtmpConnection requires RTMP or RTMPS."
                )
            )
        }

        this.config = config

        return Result.success(Unit)
    }

    override fun connect(): Result<Unit> {

        if (config == null) {
            return Result.failure(
                IllegalStateException(
                    "RTMP connection is not configured."
                )
            )
        }

        /*
         * Actual network connection will be implemented
         * with the selected streaming transport library.
         */
        connected = true

        return Result.success(Unit)
    }

    override fun send(
        packet: StreamPacket
    ): Result<Unit> {

        if (!connected) {
            return Result.failure(
                IllegalStateException(
                    "RTMP connection is not connected."
                )
            )
        }

        if (packet.data.isEmpty()) {
            return Result.failure(
                IllegalArgumentException(
                    "Cannot send an empty packet."
                )
            )
        }

        /*
         * Actual RTMP packet transmission is intentionally
         * left for the platform/network implementation.
         */

        return Result.success(Unit)
    }

    override fun disconnect(): Result<Unit> {

        connected = false

        return Result.success(Unit)
    }

    override fun isConnected(): Boolean {
        return connected
    }
}
