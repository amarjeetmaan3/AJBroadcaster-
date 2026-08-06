package com.amarjeetmaan.ajbroadcaster.core

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provides coroutine dispatchers.
 *
 * This abstraction allows repositories, use cases, and ViewModels
 * to avoid hardcoding Dispatchers.IO, Dispatchers.Main, etc.
 *
 * It also makes unit testing much easier because test dispatchers
 * can be injected.
 */
interface DispatcherProvider {

    /**
     * Main/UI thread.
     */
    val main: CoroutineDispatcher

    /**
     * Background IO operations.
     * (Firebase, Room, File operations, Network)
     */
    val io: CoroutineDispatcher

    /**
     * CPU intensive operations.
     */
    val default: CoroutineDispatcher

    /**
     * Mainly for testing.
     */
    val unconfined: CoroutineDispatcher
}
