package com.amarjeetmaan.ajbroadcaster.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Utility methods for date and time formatting.
 *
 * All date/time formatting used throughout the application
 * should be centralized here.
 */
object DateTimeUtils {

    private const val DEFAULT_DATE_PATTERN = "dd MMM yyyy"
    private const val DEFAULT_TIME_PATTERN = "hh:mm a"
    private const val DEFAULT_DATE_TIME_PATTERN = "dd MMM yyyy hh:mm a"

    /**
     * Formats milliseconds into a date.
     */
    fun formatDate(
        timeInMillis: Long,
        pattern: String = DEFAULT_DATE_PATTERN
    ): String {
        return SimpleDateFormat(
            pattern,
            Locale.getDefault()
        ).format(Date(timeInMillis))
    }

    /**
     * Formats milliseconds into a time.
     */
    fun formatTime(
        timeInMillis: Long,
        pattern: String = DEFAULT_TIME_PATTERN
    ): String {
        return SimpleDateFormat(
            pattern,
            Locale.getDefault()
        ).format(Date(timeInMillis))
    }

    /**
     * Formats milliseconds into date and time.
     */
    fun formatDateTime(
        timeInMillis: Long,
        pattern: String = DEFAULT_DATE_TIME_PATTERN
    ): String {
        return SimpleDateFormat(
            pattern,
            Locale.getDefault()
        ).format(Date(timeInMillis))
    }

    /**
     * Returns current system time in milliseconds.
     */
    fun currentTimeMillis(): Long {
        return System.currentTimeMillis()
    }
}
