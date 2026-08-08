package com.amarjeetmaan.ajbroadcaster.encoder

data class EncodedPacket(
    val timestampUs: Long,
    val type: EncoderFrameType,
    val keyFrame: Boolean,
    val data: ByteArray
) {

    init {
        require(data.isNotEmpty()) {
            "Encoded packet data cannot be empty."
        }
    }

    val sizeBytes: Int
        get() = data.size

    fun copyData(): ByteArray {
        return data.copyOf()
    }
}
