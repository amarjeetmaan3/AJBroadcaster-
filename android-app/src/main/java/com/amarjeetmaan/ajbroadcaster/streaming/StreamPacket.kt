package com.amarjeetmaan.ajbroadcaster.streaming

data class StreamPacket(
    val timestampUs: Long,
    val type: StreamPacketType,
    val data: ByteArray,
    val keyFrame: Boolean = false
) {

    init {
        require(data.isNotEmpty()) {
            "Stream packet cannot be empty."
        }
    }

    val sizeBytes: Int
        get() = data.size

    fun copyData(): ByteArray {
        return data.copyOf()
    }
}

enum class StreamPacketType {
    VIDEO,
    AUDIO
}
