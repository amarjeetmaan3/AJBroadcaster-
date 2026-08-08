package com.amarjeetmaan.ajbroadcaster.camera

/**
 * Platform-neutral camera preview contract.
 *
 * CameraX/PreviewView implementation belongs in the
 * Android UI/platform layer.
 */
interface CameraPreview {

    fun attach(
        cameraId: String
    ): Result<Unit>

    fun detach()

    fun setMirror(
        enabled: Boolean
    )

    fun setRotation(
        degrees: Int
    )
}
