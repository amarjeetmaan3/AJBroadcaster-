package com.amarjeetmaan.ajbroadcaster.streaming

import com.amarjeetmaan.ajbroadcaster.data.model.StreamSession

/**
 * Runtime configuration used by the streaming engine.
 */
data class StreamConfig(

    val sessionId: String,

    val matchId: String,

    val platform: String,

    val rtmpUrl: String,

    val streamKey: String,

    val resolution: String,

    val videoBitrateKbps: Int,

    val audioBitrateKbps: Int,

    val frameRate: Int,

    val protocol: String,

    val recordingEnabled: Boolean
) {

    companion object {

        /**
         * Creates streaming configuration
         * from the application's StreamSession model.
         */
        fun fromSession(
            session: StreamSession
        ): StreamConfig {

            return StreamConfig(
                sessionId = session.id,
                matchId = session.matchId,
                platform = session.platform,
                rtmpUrl = session.rtmpUrl,
                streamKey = session.streamKey,
                resolution = session.resolution.ifBlank {
                    "1280x720"
                },
                videoBitrateKbps =
                    session.videoBitrate.takeIf {
                        it > 0
                    } ?: 2500,
                audioBitrateKbps =
                    session.audioBitrate.takeIf {
                        it > 0
                    } ?: 128,
                frameRate =
                    session.frameRate.takeIf {
                        it > 0
                    } ?: 30,
                protocol = session.protocol.ifBlank {
                    "RTMP"
                },
                recordingEnabled =
                    session.isRecording
            )
        }
    }
}
