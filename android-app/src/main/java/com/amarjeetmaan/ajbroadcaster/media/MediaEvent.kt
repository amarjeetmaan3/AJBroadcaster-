package com.amarjeetmaan.ajbroadcaster.media

sealed class MediaEvent {

    data class Started(
        val sessionId: String
    ) : MediaEvent()

    data class Stopped(
        val sessionId: String
    ) : MediaEvent()

    data class Paused(
        val sessionId: String
    ) : MediaEvent()

    data class Resumed(
        val sessionId: String
    ) : MediaEvent()

    data class VideoFrameReceived(
        val timestampNs: Long
    ) : MediaEvent()

    data class AudioFrameReceived(
        val timestampNs: Long
    ) : MediaEvent()

    data class PipelineStarted(
        val pipelineId: String
    ) : MediaEvent()

    data class PipelineStopped(
        val pipelineId: String
    ) : MediaEvent()

    data class Error(
        val message: String
    ) : MediaEvent()
}
