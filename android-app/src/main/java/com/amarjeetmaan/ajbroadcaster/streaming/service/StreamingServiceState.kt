package com.amarjeetmaan.ajbroadcaster.streaming.service

data class StreamingServiceState(
    val running: Boolean = false,
    val foreground: Boolean = false,
    val streamActive: Boolean = false,
    val error: String? = null
)
