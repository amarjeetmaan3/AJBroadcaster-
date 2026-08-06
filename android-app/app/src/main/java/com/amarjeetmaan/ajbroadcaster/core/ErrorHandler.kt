package com.amarjeetmaan.ajbroadcaster.core

import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Converts technical exceptions into user-friendly messages.
 *
 * This class is intended for displaying safe error messages
 * to users without exposing internal implementation details.
 */
object ErrorHandler {

    /**
     * Returns a readable error message for the given exception.
     */
    fun getErrorMessage(throwable: Throwable): String {
        return when (throwable) {

            is IOException ->
                "Please check your internet connection."

            is SocketTimeoutException ->
                "Request timed out. Please try again."

            is SecurityException ->
                "Permission denied."

            is IllegalArgumentException ->
                "Invalid input."

            else ->
                throwable.message ?: "Something went wrong."
        }
    }
}
