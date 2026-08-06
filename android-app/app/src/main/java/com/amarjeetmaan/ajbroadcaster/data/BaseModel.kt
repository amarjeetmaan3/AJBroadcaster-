package com.amarjeetmaan.ajbroadcaster.data

/**
 * Base model for all data objects in AJ Broadcaster.
 *
 * Every model stored in Firebase or exchanged between
 * application layers should inherit from this class.
 *
 * Examples:
 * - Player
 * - Team
 * - Match
 * - Tournament
 * - Sponsor
 * - Stream
 * - Graphics
 */
open class BaseModel(

    /**
     * Unique identifier.
     * Usually the Firebase push key.
     */
    open var id: String = "",

    /**
     * Creation timestamp (milliseconds).
     */
    open var createdAt: Long = System.currentTimeMillis(),

    /**
     * Last update timestamp (milliseconds).
     */
    open var updatedAt: Long = System.currentTimeMillis(),

    /**
     * Soft delete flag.
     * Records are normally hidden instead of permanently deleted.
     */
    open var isDeleted: Boolean = false
)
