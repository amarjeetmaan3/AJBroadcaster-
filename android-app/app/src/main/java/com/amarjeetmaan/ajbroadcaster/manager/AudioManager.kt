package com.amarjeetmaan.ajbroadcaster.manager

import android.content.Context
import android.media.AudioManager as AndroidAudioManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages audio configuration for broadcasting.
 *
 * Responsible for microphone state,
 * audio routing, and audio settings.
 */
@Singleton
class AudioManager @Inject constructor(
    @ApplicationContext
    private val context: Context
) {

    private val audioManager =
        context.getSystemService(
            Context.AUDIO_SERVICE
        ) as AndroidAudioManager

    /**
     * Mutes the microphone.
     *
     * Actual implementation will be
     * added in future phases.
     */
    fun muteMicrophone() {
        // Reserved for future implementation.
    }

    /**
     * Unmutes the microphone.
     */
    fun unmuteMicrophone() {
        // Reserved for future implementation.
    }

    /**
     * Returns whether the microphone is muted.
     */
    fun isMicrophoneMuted(): Boolean {
        return false
    }

    /**
     * Sets the media volume.
     *
     * @param volume Volume level.
     */
    fun setMediaVolume(
        volume: Int
    ) {
        audioManager.setStreamVolume(
            AndroidAudioManager.STREAM_MUSIC,
            volume,
            0
        )
    }

    /**
     * Returns the current media volume.
     */
    fun getMediaVolume(): Int {
        return audioManager.getStreamVolume(
            AndroidAudioManager.STREAM_MUSIC
        )
    }

    /**
     * Returns the maximum media volume.
     */
    fun getMaxMediaVolume(): Int {
        return audioManager.getStreamMaxVolume(
            AndroidAudioManager.STREAM_MUSIC
        )
    }
}
