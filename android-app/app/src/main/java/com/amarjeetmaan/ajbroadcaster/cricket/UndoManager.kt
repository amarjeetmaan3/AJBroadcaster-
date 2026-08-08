package com.amarjeetmaan.ajbroadcaster.cricket

/**
 * Unlimited in-memory undo/redo manager for cricket states.
 *
 * Every scoring action can store a complete MatchState,
 * allowing the scorer to reverse a mistake without
 * reconstructing the previous score manually.
 */
class UndoManager {

    private val undoStack =
        ArrayDeque<MatchState>()

    private val redoStack =
        ArrayDeque<MatchState>()

    fun record(
        state: MatchState
    ) {
        undoStack.addLast(state)
        redoStack.clear()
    }

    fun canUndo(): Boolean {
        return undoStack.isNotEmpty()
    }

    fun canRedo(): Boolean {
        return redoStack.isNotEmpty()
    }

    fun undo(
        currentState: MatchState
    ): MatchState? {

        if (undoStack.isEmpty()) {
            return null
        }

        val previous = undoStack.removeLast()

        redoStack.addLast(currentState)

        return previous
    }

    fun redo(
        currentState: MatchState
    ): MatchState? {

        if (redoStack.isEmpty()) {
            return null
        }

        val next = redoStack.removeLast()

        undoStack.addLast(currentState)

        return next
    }

    fun clear() {
        undoStack.clear()
        redoStack.clear()
    }

    fun undoCount(): Int {
        return undoStack.size
    }

    fun redoCount(): Int {
        return redoStack.size
    }
}
