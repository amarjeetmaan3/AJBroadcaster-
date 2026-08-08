package com.amarjeetmaan.ajbroadcaster.encoder

import kotlinx.coroutines.flow.StateFlow

class EncoderEngine(
    private val controller: EncoderController
) {

    val state: StateFlow<EncoderState>
        get() = controller.state

    val events
        get() = controller.events

    fun configure(
        config: EncoderConfig
    ): Result<Unit> {
        return controller.configure(config)
    }

    fun start(): Result<Unit> {
        return controller.start()
    }

    fun stop(): Result<Unit> {
        return controller.stop()
    }

    fun encode(
        frame: EncoderFrame
    ): Result<EncodedPacket> {
        return controller.encode(frame)
    }

    fun flush(): Result<List<EncodedPacket>> {
        return controller.flush()
    }

    fun release() {
        controller.release()
    }
}
