package com.amarjeetmaan.ajbroadcaster.streaming

data class StreamStatistics(
    val packetsSent: Long = 0L,
    val bytesSent: Long = 0L,
    val videoPackets: Long = 0L,
    val audioPackets: Long = 0L,
    val droppedPackets: Long = 0L,
    val reconnectCount: Int = 0
) {

    val megabytesSent: Double
        get() =
            bytesSent / 1_048_576.0

    fun record(
        packet: StreamPacket
    ): StreamStatistics {

        return copy(
            packetsSent =
                packetsSent + 1,
            bytesSent =
                bytesSent +
                    packet.sizeBytes.toLong(),
            videoPackets =
                videoPackets +
                    if (
                        packet.type ==
                        StreamPacketType.VIDEO
                    ) 1 else 0,
            audioPackets =
                audioPackets +
                    if (
                        packet.type ==
                        StreamPacketType.AUDIO
                    ) 1 else 0
        )
    }

    fun recordDrop():
        StreamStatistics {

        return copy(
            droppedPackets =
                droppedPackets + 1
        )
    }

    fun recordReconnect():
        StreamStatistics {

        return copy(
            reconnectCount =
                reconnectCount + 1
        )
    }
}
