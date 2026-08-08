package com.amarjeetmaan.ajbroadcaster.streaming

interface StreamConnection {

    fun configure(
        config: StreamingConfig
    ): Result<Unit>

    fun connect(): Result<Unit>

    fun send(
        packet: StreamPacket
    ): Result<Unit>

    fun disconnect(): Result<Unit>

    fun isConnected(): Boolean
}
