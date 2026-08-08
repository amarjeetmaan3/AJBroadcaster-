package com.amarjeetmaan.ajbroadcaster.director

class DirectorCommandProcessor(
    private val controller: DirectorController,
    private val sceneProvider:
        (String) -> DirectorScene? = { null },
    private val presetManager:
        DirectorPresetManager =
            DirectorPresetManager()
) {

    fun process(
        command: DirectorCommand
    ): Result<Unit> {

        return when (command) {

            DirectorCommand.Start -> {

                val current =
                    controller.state.value

                if (current is DirectorState.Live) {
                    Result.success(Unit)
                } else {
                    Result.failure(
                        IllegalStateException(
                            "Start requires a live session."
                        )
                    )
                }
            }

            DirectorCommand.Stop -> {
                controller.stopSession()
            }

            DirectorCommand.Go -> {
                executeLiveCommand("GO")
            }

            DirectorCommand.Take -> {
                executeLiveCommand("TAKE")
            }

            DirectorCommand.Cut -> {
                executeLiveCommand("CUT")
            }

            DirectorCommand.NextScene -> {
                executeLiveCommand("NEXT_SCENE")
            }

            is DirectorCommand.SelectScene -> {

                val scene =
                    sceneProvider(
                        command.sceneId
                    )
                        ?: return Result.failure(
                            NoSuchElementException(
                                "Scene not found: " +
                                    command.sceneId
                            )
                        )

                controller.setScene(
                    scene
                )
            }

            is DirectorCommand.RecallPreset -> {

                val preset =
                    presetManager
                        .load(
                            command.presetId
                        )
                        .getOrElse {
                            return Result.failure(it)
                        }

                controller.setScene(
                    preset.scene
                )
            }
        }
    }

    private fun executeLiveCommand(
        commandName: String
    ): Result<Unit> {

        if (
            controller.state.value
            !is DirectorState.Live
        ) {
            return Result.failure(
                IllegalStateException(
                    "No live director session."
                )
            )
        }

        controller.commandExecuted(
            commandName
        )

        return Result.success(Unit)
    }
}
