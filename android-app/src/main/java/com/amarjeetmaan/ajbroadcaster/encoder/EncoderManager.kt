package com.amarjeetmaan.ajbroadcaster.encoder

class EncoderManager {

    private var controller:
        EncoderController? = null

    private var videoEncoder:
        VideoEncoder? = null

    private var audioEncoder:
        AudioEncoder? = null

    fun create(): Result<Unit> {

        if (controller != null) {
            return Result.success(Unit)
        }

        val newController =
            EncoderController()

        controller =
            newController

        videoEncoder =
            VideoEncoder(
                newController
            )

        audioEncoder =
            AudioEncoder(
                newController
            )

        return Result.success(Unit)
    }

    fun configure(
        config: EncoderConfig
    ): Result<Unit> {

        return controller
            ?.configure(config)
            ?: Result.failure(
                IllegalStateException(
                    "Encoder manager has not been created."
                )
            )
    }

    fun start(): Result<Unit> {

        return controller
            ?.start()
            ?: Result.failure(
                IllegalStateException(
                    "Encoder manager has not been created."
                )
            )
    }

    fun stop(): Result<Unit> {

        return controller
            ?.stop()
            ?: Result.failure(
                IllegalStateException(
                    "Encoder manager has not been created."
                )
            )
    }

    fun encodeVideo(
        frame: EncoderFrame
    ): Result<EncodedPacket> {

        return videoEncoder
            ?.encode(frame)
            ?: Result.failure(
                IllegalStateException(
                    "Video encoder is unavailable."
                )
            )
    }

    fun encodeAudio(
        frame: EncoderFrame
    ): Result<EncodedPacket> {

        return audioEncoder
            ?.encode(frame)
            ?: Result.failure(
                IllegalStateException(
                    "Audio encoder is unavailable."
                )
            )
    }

    fun flush():
        Result<List<EncodedPacket>> {

        return controller
            ?.flush()
            ?: Result.failure(
                IllegalStateException(
                    "Encoder manager has not been created."
                )
            )
    }

    fun release() {

        controller?.release()

        videoEncoder = null
        audioEncoder = null
        controller = null
    }

    fun isCreated(): Boolean {
        return controller != null
    }
}
