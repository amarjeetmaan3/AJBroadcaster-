package com.amarjeetmaan.ajbroadcaster.director

sealed class DirectorState {

    data object Idle : DirectorState()

    data class Live(
        val session: DirectorSession,
        val scene: DirectorScene
    ) : DirectorState()

    data class Busy(
        val busy: Boolean,
        val session: DirectorSession
    ) : DirectorState()

    data class Error(
        val message: String
    ) : DirectorState()
}
