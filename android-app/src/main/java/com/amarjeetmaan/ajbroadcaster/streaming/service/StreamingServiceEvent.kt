package com.amarjeetmaan.ajbroadcaster.streaming.service

sealed class StreamingServiceEvent {

    data object ServiceStarted : StreamingServiceEvent()

    data object ServiceStopped : StreamingServiceEvent()

    data object StreamStarted : StreamingServiceEvent()

    data object StreamStopped : StreamingServiceEvent()

    data object ServiceDestroyed : StreamingServiceEvent()

    data class Error(
        val message: String
    ) : StreamingServiceEvent()
}
