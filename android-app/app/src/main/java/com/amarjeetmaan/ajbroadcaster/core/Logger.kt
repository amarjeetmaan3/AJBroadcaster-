package com.amarjeetmaan.ajbroadcaster.core

import android.util.Log
import com.amarjeetmaan.ajbroadcaster.constants.AppConstants
import com.amarjeetmaan.ajbroadcaster.constants.BuildConstants

/**
 * Centralized logging utility for AJ Broadcaster.
 *
 * Rules:
 * - Use Logger instead of android.util.Log directly.
 * - Logs are automatically disabled in Release builds.
 * - Keep sensitive information out of logs.
 */
object Logger {

    fun d(
        tag: String = AppConstants.LOG_TAG,
        message: String
    ) {
        if (BuildConstants.IS_DEBUG) {
            Log.d(tag, message)
        }
    }

    fun i(
        tag: String = AppConstants.LOG_TAG,
        message: String
    ) {
        if (BuildConstants.IS_DEBUG) {
            Log.i(tag, message)
        }
    }

    fun w(
        tag: String = AppConstants.LOG_TAG,
        message: String,
        throwable: Throwable? = null
    ) {
        if (BuildConstants.IS_DEBUG) {
            if (throwable == null) {
                Log.w(tag, message)
            } else {
                Log.w(tag, message, throwable)
            }
        }
    }

    fun e(
        tag: String = AppConstants.LOG_TAG,
        message: String,
        throwable: Throwable? = null
    ) {
        if (BuildConstants.IS_DEBUG) {
            if (throwable == null) {
                Log.e(tag, message)
            } else {
                Log.e(tag, message, throwable)
            }
        }
    }

    fun v(
        tag: String = AppConstants.LOG_TAG,
        message: String
    ) {
        if (BuildConstants.IS_DEBUG) {
            Log.v(tag, message)
        }
    }
}
