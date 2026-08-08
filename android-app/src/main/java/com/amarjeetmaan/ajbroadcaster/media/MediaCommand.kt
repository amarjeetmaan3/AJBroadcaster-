package com.amarjeetmaan.ajbroadcaster.media

sealed class MediaCommand {

    data class Start(
        val session: MediaSession
    ) : MediaCommand()

    data object Stop : MediaCommand()

    data object Pause : MediaCommand()

    data object Resume : MediaCommand()

    data class SubmitVideo(
        val frame: MediaFrame
    ) : MediaCommand()

    data class SubmitAudio(
        val frame: MediaFrame
    ) : MediaCommand()
}
