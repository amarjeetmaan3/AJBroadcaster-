package com.amarjeetmaan.ajbroadcaster.audio

/**
 * Platform-neutral audio capture contract.
 *
 * Android AudioRecord implementation belongs
 * in the platform/service layer.
 */
interface AudioCapture {

    fun configure(
        config: AudioConfig
    ): Result<Unit>

    fun start(): Result<Unit>

    fun stop(): Result<Unit>

    fun read(
        buffer: ShortArray
    ): Int

    fun release()
}
