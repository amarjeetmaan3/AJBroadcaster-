package com.amarjeetmaan.ajbroadcaster.encoder

class VideoEncoder(
    private val controller: EncoderController
) {

    fun configure(
        config: EncoderConfig
    ): Result<Unit> {

        return controller.configure(
            config.copy(
                codec =
                    when (config.codec) {
                        EncoderCodec.H264 ->
                            EncoderCodec.H264

                        EncoderCodec.HEVC ->
                            EncoderCodec.HEVC

                        EncoderCodec.AV1 ->
                            EncoderCodec.AV1
                    }
            )
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
            EncoderFrameType.VIDEO
        ) {
            return Result.failure(
                IllegalArgumentException(
                    "VideoEncoder accepts only video frames."
                )
            )
        }

        return controller.encode(
            frame
        )
    }
}
