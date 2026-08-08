package com.amarjeetmaan.ajbroadcaster.streaming.service

import com.amarjeetmaan.ajbroadcaster.streaming.StreamPacket
import com.amarjeetmaan.ajbroadcaster.streaming.StreamingConfig

sealed class StreamingServiceCommand {

    data object StartService :
        StreamingServiceCommand()

    data class Configure(
        val config: StreamingConfig
    ) : StreamingServiceCommand()

    data object StartStream :
        StreamingServiceCommand()

    data class Send(
        val packet: StreamPacket
    ) : StreamingServiceCommand()

    data object StopStream :
        StreamingServiceCommand()

    data object StopService :
        StreamingServiceCommand()
}
