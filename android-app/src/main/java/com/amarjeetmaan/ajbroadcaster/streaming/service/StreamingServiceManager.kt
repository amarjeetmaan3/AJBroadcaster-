package com.amarjeetmaan.ajbroadcaster.streaming.service

import com.amarjeetmaan.ajbroadcaster.streaming.StreamPacket
import com.amarjeetmaan.ajbroadcaster.streaming.StreamingConfig

class StreamingServiceManager(
    private val controller:
        StreamingServiceController =
        StreamingServiceController()
) : StreamingService {

    override fun startService():
        Result<Unit> {

        return controller.startService()
    }

    override fun configure(
        config: StreamingConfig
    ): Result<Unit> {

        return controller.configure(
            config
        )
    }

    override fun startStream():
        Result<Unit> {

        return controller.startStream()
    }

    override fun send(
        packet: StreamPacket
    ): Result<Unit> {

        return controller.send(
            packet
        )
    }

    override fun stopStream():
        Result<Unit> {

        return controller.stopStream()
    }

    override fun stopService():
        Result<Unit> {

        return controller.stopService()
    }

    fun state() =
        controller.state

    fun events() =
        controller.events

    fun destroy() {
        controller.destroy()
    }
}
