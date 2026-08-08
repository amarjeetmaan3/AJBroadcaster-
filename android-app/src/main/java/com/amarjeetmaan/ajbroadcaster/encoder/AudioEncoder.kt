package com.amarjeetmaan.ajbroadcaster.encoder

class AudioEncoder(
    private val controller: EncoderController
) {

    fun configure(
        config: EncoderConfig
    ): Result<Unit> {
        return controller.configure(
            config
        )
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

        if (
            frame.type !=
            EncoderFrameType.AUDIO
        ) {
            return Result.failure(
                IllegalArgumentException(
                    "AudioEncoder accepts only audio frames."
                )
            )
        }

        return controller.encode(
            frame
        )
    }
}
