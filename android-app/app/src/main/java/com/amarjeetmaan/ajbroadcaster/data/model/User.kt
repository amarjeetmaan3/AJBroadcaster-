package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents an application user.
 *
 * This model is shared between Firebase, repositories,
 * ViewModels, and UI.
 */
data class User(

    /**
     * Unique user identifier.
     */
    val id: String = "",

    /**
     * Full display name.
     */
    val fullName: String = "",

    /**
     * Email address.
     */
    val email: String = "",

    /**
     * Mobile number.
     */
    val phoneNumber: String = "",

    /**
     * Profile image URL.
     */
    val profileImage: String = "",

    /**
     * User role.
     *
     * Examples:
     * Admin
     * Scorer
     * Umpire
     * Stream Operator
     * Viewer
     */
    val role: String = "",

    /**
     * Account status.
     *
     * Examples:
     * Active
     * Disabled
     * Suspended
     */
    val status: String = "",

    /**
     * Account creation timestamp.
     */
    val createdAt: Long = 0L,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
