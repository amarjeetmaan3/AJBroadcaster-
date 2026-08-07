# Streaming Package

Package:

com.amarjeetmaan.ajbroadcaster.streaming

---

## Purpose

The Streaming package is responsible for managing all live streaming operations in AJ Broadcaster.

It captures encoded video and audio, establishes streaming connections, monitors stream health, and controls the broadcast lifecycle.

This package should remain independent from cricket scoring, tournament management, and UI logic.

---

## Responsibilities

The Streaming module manages:

- Stream initialization
- Live stream start
- Live stream stop
- Stream pause and resume
- Video encoding
- Audio encoding
- RTMP connection
- Stream health monitoring
- Bitrate management
- Reconnection handling
- Stream statistics
- Recording integration

---

## Supported Platforms

Future support includes:

- YouTube Live
- Facebook Live
- Custom RTMP Server
- Local Network Streaming

Additional platforms can be added without changing the architecture.

---

## Future Files

Examples:

- StreamingManager.kt
- StreamingController.kt
- StreamSession.kt
- StreamState.kt
- StreamStatistics.kt
- BitrateController.kt
- EncoderManager.kt
- RTMPClient.kt
- ReconnectManager.kt
- RecordingManager.kt

---

## Planned Features

### Stream Control

- Start Stream
- Stop Stream
- Pause Stream
- Resume Stream

---

### Connection Management

- Connect to RTMP server
- Automatic reconnect
- Connection timeout
- Connection quality monitoring

---

### Video Encoding

Future support:

- H.264
- H.265
- Hardware Encoder
- Software Encoder

---

### Audio Encoding

Future support:

- AAC
- Stereo Audio
- Mono Audio

---

### Quality Control

- Auto Bitrate
- Manual Bitrate
- Resolution Selection
- FPS Selection

---

### Broadcast Statistics

Display:

- Live Duration
- Upload Speed
- Bitrate
- FPS
- Frames Dropped
- Audio Status
- Video Status
- Network Quality

---

## Architecture Rules

### Rule 1

No cricket scoring logic.

---

### Rule 2

No UI components inside Streaming.

---

### Rule 3

No Firebase database operations.

---

### Rule 4

Receive video only from Camera module.

---

### Rule 5

Receive audio only from Audio module.

---

### Rule 6

Provide stream state to Director and Graphics modules.

---

## Dependency Flow

Camera

+

Audio

↓

Streaming Package

↓

RTMP Server

↓

YouTube / Facebook Live

---

## Status

Streaming Foundation

Documentation Complete

Implementation Pending
