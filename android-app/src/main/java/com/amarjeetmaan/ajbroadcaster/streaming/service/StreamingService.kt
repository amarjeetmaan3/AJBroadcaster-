package com.amarjeetmaan.ajbroadcaster.streaming.service

/**
 * Service abstraction.
 *
 * The Android Service implementation belongs in the
 * Android platform layer and should delegate its work
 * to StreamingServiceController.
 */
interface StreamingService {

    fun startService(): Result<Unit>

    fun configure(
        config: com.amarjeetmaan.ajbroadcaster.streaming.StreamingConfig
    ): Result<Unit>

    fun startStream(): Result<Unit>

    fun send(
        packet: com.amarjeetmaan.ajbroadcaster.streaming.StreamPacket
    ): Result<Unit>

    fun stopStream(): Result<Unit>

    fun stopService(): Result<Unit>
}
