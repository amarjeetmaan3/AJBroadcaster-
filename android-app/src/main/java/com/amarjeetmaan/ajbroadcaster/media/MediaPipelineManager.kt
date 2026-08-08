package com.amarjeetmaan.ajbroadcaster.media

class MediaPipelineManager {

    private var videoPipeline:
        VideoPipeline? = null

    private var audioPipeline:
        AudioPipeline? = null

    private var active = false

    fun create(
        videoPipelineId: String,
        audioPipelineId: String
    ): Result<Unit> {

        if (videoPipelineId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Video pipeline ID is required."
                )
            )
        }

        if (audioPipelineId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Audio pipeline ID is required."
                )
            )
        }

        videoPipeline =
            VideoPipeline(
                videoPipelineId
            )

        audioPipeline =
            AudioPipeline(
                audioPipelineId
            )

        return Result.success(Unit)
    }

    fun start(): Result<Unit> {

        val video =
            videoPipeline
                ?: return Result.failure(
                    IllegalStateException(
                        "Video pipeline has not been created."
                    )
                )

        val audio =
            audioPipeline
                ?: return Result.failure(
                    IllegalStateException(
                        "Audio pipeline has not been created."
                    )
                )

        video.start()
            .getOrElse {
                return Result.failure(it)
            }

        audio.start()
            .getOrElse {
                video.stop()
                return Result.failure(it)
            }

        active = true

        return Result.success(Unit)
    }

    fun stop(): Result<Unit> {

        videoPipeline?.stop()
        audioPipeline?.stop()

        active = false

        return Result.success(Unit)
    }

    fun submit(
        frame: MediaFrame
    ): Result<Unit> {

        if (!active) {
            return Result.failure(
                IllegalStateException(
                    "Media pipelines are not running."
                )
            )
        }

        return when (
            frame.type
        ) {

            MediaFrameType.VIDEO ->
                videoPipeline
                    ?.submit(frame)
                    ?: Result.failure(
                        IllegalStateException(
                            "Video pipeline is unavailable."
                        )
                    )

            MediaFrameType.AUDIO ->
                audioPipeline
                    ?.submit(frame)
                    ?: Result.failure(
                        IllegalStateException(
                            "Audio pipeline is unavailable."
                        )
                    )
        }
    }

    fun isActive(): Boolean {
        return active
    }

    fun getVideoPipeline():
        VideoPipeline? {
        return videoPipeline
    }

    fun getAudioPipeline():
        AudioPipeline? {
        return audioPipeline
    }

    fun release() {

        videoPipeline?.reset()
        audioPipeline?.reset()

        videoPipeline = null
        audioPipeline = null

        active = false
    }
}
