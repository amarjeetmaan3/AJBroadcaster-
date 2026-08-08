package com.amarjeetmaan.ajbroadcaster.media

class AudioPipeline(
    private val pipelineId: String
) {

    private var running = false

    private var frameCount = 0L

    fun start(): Result<Unit> {

        if (pipelineId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Audio pipeline ID is required."
                )
            )
        }

        running = true

        return Result.success(Unit)
    }

    fun stop(): Result<Unit> {

        running = false

        return Result.success(Unit)
    }

    fun submit(
        frame: MediaFrame
    ): Result<Unit> {

        if (!running) {
            return Result.failure(
                IllegalStateException(
                    "Audio pipeline is not running."
                )
            )
        }

        if (
            frame.type !=
            MediaFrameType.AUDIO
        ) {
            return Result.failure(
                IllegalArgumentException(
                    "Frame is not an audio frame."
                )
            )
        }

        frameCount++

        return Result.success(Unit)
    }

    fun isRunning(): Boolean {
        return running
    }

    fun frameCount(): Long {
        return frameCount
    }

    fun reset() {
        frameCount = 0L
        running = false
    }
}
