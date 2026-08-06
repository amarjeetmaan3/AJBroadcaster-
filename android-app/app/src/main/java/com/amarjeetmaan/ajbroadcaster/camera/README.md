# Camera Package

Package:

com.amarjeetmaan.ajbroadcaster.camera

---

## Purpose

The Camera package is responsible for controlling all camera-related operations used during live broadcasting.

This package provides a single interface for camera management regardless of the underlying camera hardware.

It should not contain cricket logic, graphics logic, or UI business logic.

---

## Responsibilities

The Camera module manages:

- Camera initialization
- Camera preview
- Front/Rear camera switching
- Zoom control
- Focus control
- Exposure control
- Torch (Flash) control
- Video resolution
- Frame rate
- Bitrate
- Camera orientation
- Camera lifecycle

---

## Future Files

Examples:

- CameraManager.kt
- CameraController.kt
- CameraState.kt
- CameraSettings.kt
- CameraPreview.kt
- CameraSelector.kt
- ZoomController.kt
- FocusController.kt
- TorchController.kt
- VideoRecorder.kt
- CameraPermissionManager.kt

---

## Planned Features

### Preview

- Live camera preview
- Full-screen preview
- Preview scaling

---

### Controls

- Switch camera
- Pinch to zoom
- Tap to focus
- Exposure adjustment
- Flash control

---

### Video

- HD Streaming
- Full HD Streaming
- Future 4K support
- Bitrate selection
- Frame rate selection

---

### Broadcasting

The camera module will provide video to:

- Streaming Engine
- Director Module
- Graphics Overlay
- Recording Module

The camera package itself should not know where the video is used.

---

## Architecture Rules

### Rule 1

No cricket scoring logic.

---

### Rule 2

No Firebase operations.

---

### Rule 3

No tournament management.

---

### Rule 4

Camera module should expose a clean API for other modules.

Example

CameraManager.startPreview()

CameraManager.stopPreview()

CameraManager.switchCamera()

---

### Rule 5

Use Android CameraX as the primary camera framework.

Future support for Camera2 may be added if required.

---

## Dependency Flow

Camera Hardware

↓

Camera Package

↓

Streaming Module

↓

Director Module

↓

Graphics Overlay

---

## Status

Camera Foundation

Documentation Complete

Implementation Pending
