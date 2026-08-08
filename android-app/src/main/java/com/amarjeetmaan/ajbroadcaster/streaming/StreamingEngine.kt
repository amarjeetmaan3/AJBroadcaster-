package com.amarjeetmaan.ajbroadcaster.streaming

import kotlinx.coroutines.flow.StateFlow

class StreamingEngine(
    private val controller: StreamingController
) {

    val state: StateFlow<StreamingState>
        get() = controller.state

    val events
        get() = controller.events

    fun configure(
        config: StreamingConfig
    ): Result<Unit> {
        return controller.configure(config)
    }

    fun connect(): Result<Unit> {
        return controller.connect()
    }

    fun start(): Result<Unit> {
        return controller.start()
    }

    fun stop(): Result<Unit> {
        return controller.stop()
    }

    fun disconnect(): Result<Unit> {
        return controller.disconnect()
    }

    fun send(
        packet: StreamPacket
    ): Result<Unit> {
        return controller.send(packet)
    }
}
