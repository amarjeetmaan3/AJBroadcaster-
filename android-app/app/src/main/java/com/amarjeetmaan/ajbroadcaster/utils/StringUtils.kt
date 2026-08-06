package com.amarjeetmaan.ajbroadcaster.utils

/**
 * Common string utility functions.
 *
 * Keep all reusable String operations here.
 * Avoid duplicating string manipulation code
 * throughout the application.
 */
object StringUtils {

    /**
     * Returns true if the string is null,
     * empty, or contains only whitespace.
     */
    fun isNullOrBlank(value: String?): Boolean {
        return value.isNullOrBlank()
    }

    /**
     * Returns an empty string if the value is null.
     */
    fun orEmpty(value: String?): String {
        return value ?: ""
    }

    /**
     * Capitalizes the first character.
     */
    fun capitalize(value: String): String {
        return value.replaceFirstChar {
            if (it.isLowerCase()) {
                it.titlecase()
            } else {
                it.toString()
            }
        }
    }

    /**
     * Removes leading and trailing spaces.
     */
    fun trim(value: String): String {
        return value.trim()
    }

    /**
     * Returns true if the string contains only digits.
     */
    fun isNumeric(value: String): Boolean {
        return value.all { it.isDigit() }
    }

    /**
     * Limits a string to the specified length.
     */
    fun limitLength(
        value: String,
        maxLength: Int
    ): String {
        return if (value.length <= maxLength) {
            value
        } else {
            value.substring(0, maxLength)
        }
    }
}
