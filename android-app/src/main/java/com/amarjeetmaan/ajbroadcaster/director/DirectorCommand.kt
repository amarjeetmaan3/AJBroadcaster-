package com.amarjeetmaan.ajbroadcaster.director

sealed class DirectorCommand {

    data object Go : DirectorCommand()

    data object Take : DirectorCommand()

    data object Cut : DirectorCommand()

    data object Start : DirectorCommand()

    data object Stop : DirectorCommand()

    data object NextScene : DirectorCommand()

    data class SelectScene(
        val sceneId: String
    ) : DirectorCommand()

    data class RecallPreset(
        val presetId: String
    ) : DirectorCommand()
}
