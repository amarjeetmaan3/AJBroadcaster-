package com.amarjeetmaan.ajbroadcaster.utils

import android.util.Patterns

/**
 * Common validation utility methods.
 *
 * Keep reusable validation logic here.
 * Do not place business rules in this class.
 */
object ValidationUtils {

    /**
     * Returns true if the value is not null,
     * not empty, and not blank.
     */
    fun isRequired(value: String?): Boolean {
        return !value.isNullOrBlank()
    }

    /**
     * Validates an email address.
     */
    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    /**
     * Validates an Indian mobile number.
     * Accepts exactly 10 digits.
     */
    fun isValidPhone(phone: String): Boolean {
        return phone.matches(Regex("^[6-9][0-9]{9}$"))
    }

    /**
     * Validates player, team,
     * tournament and sponsor names.
     */
    fun isValidName(
        value: String,
        minLength: Int = 2,
        maxLength: Int = 50
    ): Boolean {
        val text = value.trim()

        return text.length in minLength..maxLength
    }

    /**
     * Checks whether a string
     * contains only numbers.
     */
    fun isNumeric(value: String): Boolean {
        return value.all { it.isDigit() }
    }

    /**
     * Checks minimum length.
     */
    fun hasMinLength(
        value: String,
        length: Int
    ): Boolean {
        return value.length >= length
    }

    /**
     * Checks maximum length.
     */
    fun hasMaxLength(
        value: String,
        length: Int
    ): Boolean {
        return value.length <= length
    }

    /**
     * Validates a URL.
     */
    fun isValidUrl(url: String): Boolean {
        return Patterns.WEB_URL.matcher(url).matches()
    }
}
