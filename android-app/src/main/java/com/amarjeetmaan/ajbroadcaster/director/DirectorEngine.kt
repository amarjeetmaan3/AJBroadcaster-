package com.amarjeetmaan.ajbroadcaster.director

import kotlinx.coroutines.flow.StateFlow

class DirectorEngine(
    private val controller: DirectorController,
    private val commandProcessor: DirectorCommandProcessor,
    private val presetManager: DirectorPresetManager
) {

    val state: StateFlow<DirectorState>
        get() = controller.state

    val events
        get() = controller.events

    fun execute(
        command: DirectorCommand
    ): Result<Unit> {
        return commandProcessor.process(command)
    }

    fun startSession(
        session: DirectorSession
    ): Result<Unit> {
        return controller.startSession(session)
    }

    fun stopSession(): Result<Unit> {
        return controller.stopSession()
    }

    fun setScene(
        scene: DirectorScene
    ): Result<Unit> {
        return controller.setScene(scene)
    }

    fun savePreset(
        preset: DirectorPreset
    ): Result<Unit> {
        return presetManager.save(preset)
    }

    fun loadPreset(
        id: String
    ): Result<DirectorPreset> {
        return presetManager.load(id)
    }
}
