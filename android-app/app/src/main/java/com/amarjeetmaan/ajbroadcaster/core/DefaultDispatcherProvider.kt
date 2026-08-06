package com.amarjeetmaan.ajbroadcaster.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Production implementation of DispatcherProvider.
 *
 * All coroutine dispatchers used throughout the application
 * are provided from this single object.
 *
 * This keeps dispatchers centralized and makes testing easier.
 */
object DefaultDispatcherProvider : DispatcherProvider {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}
