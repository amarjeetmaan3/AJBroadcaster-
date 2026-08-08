package com.amarjeetmaan.ajbroadcaster.media

class VideoPipeline(
    private val pipelineId: String
) {

    private var running = false

    private var frameCount = 0L

    fun start(): Result<Unit> {

        if (pipelineId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Video pipeline ID is required."
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
                    "Video pipeline is not running."
                )
            )
        }

        if (
            frame.type !=
            MediaFrameType.VIDEO
        ) {
            return Result.failure(
                IllegalArgumentException(
                    "Frame is not a video frame."
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
