package com.amarjeetmaan.ajbroadcaster.streaming

class StreamingManager(
    private val controller:
        StreamingController =
        StreamingController()
) {

    private var connection:
        StreamConnection? = null

    private var statistics =
        StreamStatistics()

    fun configure(
        config: StreamingConfig
    ): Result<Unit> {

        connection =
            when (config.protocol) {

                StreamingProtocol.RTMP,
                StreamingProtocol.RTMPS ->
                    RtmpConnection()

                StreamingProtocol.SRT ->
                    return Result.failure(
                        UnsupportedOperationException(
                            "SRT transport is not implemented yet."
                        )
                    )
            }

        connection
            ?.configure(config)
            ?.getOrElse {
                return Result.failure(it)
            }

        return controller.configure(
            config
        )
    }

    fun connect(): Result<Unit> {

        connection
            ?: return Result.failure(
                IllegalStateException(
                    "Streaming has not been configured."
                )
            )

        connection
            ?.connect()
            ?.getOrElse {
                return Result.failure(it)
            }

        return controller.connect()
    }

    fun start(): Result<Unit> {
        return controller.start()
    }

    fun stop(): Result<Unit> {
        return controller.stop()
    }

    fun disconnect(): Result<Unit> {

        connection?.disconnect()

        return controller.disconnect()
    }

    fun send(
        packet: StreamPacket
    ): Result<Unit> {

        val transport =
            connection
                ?: return Result.failure(
                    IllegalStateException(
                        "Streaming connection is unavailable."
                    )
                )

        val result =
            transport.send(packet)

        if (result.isSuccess) {
            statistics =
                statistics.record(packet)

            return controller.send(packet)
        }

        statistics =
            statistics.recordDrop()

        return result
    }

    fun statistics():
        StreamStatistics {
        return statistics
    }

    fun resetStatistics() {
        statistics =
            StreamStatistics()
    }

    fun isConnected(): Boolean {
        return connection?.isConnected()
            ?: false
    }
}
