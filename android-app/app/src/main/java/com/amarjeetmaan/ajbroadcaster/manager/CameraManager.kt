package com.amarjeetmaan.ajbroadcaster.manager

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.lifecycle.LifecycleOwner
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages CameraX operations for AJ Broadcaster.
 *
 * Responsible for camera initialization,
 * preview, camera switching, zoom,
 * flash, focus, and lifecycle handling.
 *
 * Camera streaming implementation will
 * be added in future phases.
 */
@Singleton
class CameraManager @Inject constructor() {

    private var cameraProvider: ProcessCameraProvider? = null

    private var preview: Preview? = null

    private var cameraSelector: CameraSelector =
        CameraSelector.DEFAULT_BACK_CAMERA

    /**
     * Initializes CameraX.
     */
    fun initialize(
        provider: ProcessCameraProvider
    ) {
        cameraProvider = provider
    }

    /**
     * Starts the camera preview.
     *
     * Actual preview binding will
     * be implemented later.
     */
    fun startPreview(
        lifecycleOwner: LifecycleOwner
    ) {
        // CameraX preview implementation
        // will be added later.
    }

    /**
     * Stops all camera use cases.
     */
    fun stopPreview() {
        cameraProvider?.unbindAll()
    }

    /**
     * Switches between front
     * and back cameras.
     */
    fun switchCamera() {

        cameraSelector =
            if (cameraSelector ==
                CameraSelector.DEFAULT_BACK_CAMERA
            ) {
                CameraSelector.DEFAULT_FRONT_CAMERA
            } else {
                CameraSelector.DEFAULT_BACK_CAMERA
            }

        // Rebind use cases later.
    }

    /**
     * Enables or disables flash.
     *
     * Implementation will be added later.
     */
    fun setFlashEnabled(
        enabled: Boolean
    ) {
        // Reserved.
    }

    /**
     * Sets zoom ratio.
     *
     * Implementation will be added later.
     */
    fun setZoom(
        zoomRatio: Float
    ) {
        // Reserved.
    }

    /**
     * Performs focus at the
     * specified screen position.
     *
     * Implementation will be added later.
     */
    fun focus(
        x: Float,
        y: Float
    ) {
        // Reserved.
    }

    /**
     * Releases camera resources.
     */
    fun release() {
        cameraProvider?.unbindAll()
        cameraProvider = null
        preview = null
    }
}
