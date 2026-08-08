package com.amarjeetmaan.ajbroadcaster.director

sealed class DirectorEvent {

    data class SessionStarted(
        val sessionId: String
    ) : DirectorEvent()

    data class SessionStopped(
        val sessionId: String
    ) : DirectorEvent()

    data class SceneChanged(
        val sceneId: String
    ) : DirectorEvent()

    data class CommandExecuted(
        val command: String
    ) : DirectorEvent()

    data class Error(
        val message: String
    ) : DirectorEvent()
}
