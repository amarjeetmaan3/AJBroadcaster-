# Director Package

Package:

com.amarjeetmaan.ajbroadcaster.director

---

# Purpose

The Director package is the command center of AJ Broadcaster.

It controls the entire live production workflow by coordinating graphics, overlays, animations, camera operations, and broadcast actions from one place.

The Director module does not calculate cricket scores and does not perform streaming itself. Instead, it sends commands to the appropriate modules.

---

# Responsibilities

The Director module manages:

- Broadcast Control
- Camera Switching
- Graphics Control
- Overlay Control
- Animation Control
- Scoreboard Visibility
- Sponsor Control
- Replay Trigger
- Scene Switching
- Production Automation
- Match Timeline
- Operator Commands

---

# Director Dashboard

The dashboard provides control over:

- Live Match
- Graphics
- Cameras
- Audio
- Streaming
- Sponsors
- Replay
- Settings
- Emergency Controls

---

# Camera Control

Support:

- Camera 1
- Camera 2
- Camera 3
- Camera 4

Future support:

- Unlimited IP Cameras
- Wireless Cameras
- External Cameras

---

# Graphics Control

Support:

- Show Scoreboard
- Hide Scoreboard
- Show Lower Third
- Show Player Card
- Show Team Card
- Show Match Summary
- Show Partnership
- Show Statistics

---

# Animation Control

Support:

- Four
- Six
- Wicket
- Wide
- No Ball
- Fifty
- Century
- Hat-trick
- Match Winner

---

# Sponsor Control

Support:

- Banner
- Popup
- Logo
- Full Screen Advertisement
- Video Advertisement

---

# Broadcast Automation

Support:

- Auto Graphic Trigger
- Auto Animation Trigger
- Scheduled Graphics
- Automatic Sponsor Rotation

---

# Future Files

Examples:

- DirectorManager.kt
- DirectorController.kt
- DirectorState.kt
- BroadcastController.kt
- CameraSwitcher.kt
- GraphicsController.kt
- OverlayController.kt
- AnimationController.kt
- ReplayController.kt
- DirectorCommand.kt

---

# Planned Features

Support:

- One-Tap Broadcast Control
- Multi-Camera Switching
- Live Graphic Triggering
- Broadcast Macros
- Production Presets
- Custom Control Panels
- Touch Optimized Interface

---

# Architecture Rules

## Rule 1

No cricket calculations.

---

## Rule 2

Director controls modules through their public interfaces.

---

## Rule 3

Director never edits Firebase data directly.

---

## Rule 4

Every command should be reversible where possible.

---

## Rule 5

Director should remain responsive even during heavy broadcasts.

---

## Dependency Flow

Director Package

↓

Camera Package

↓

Graphics Package

↓

Animation Package

↓

Overlay Package

↓

Streaming Package

↓

Live Broadcast

---

# Status

Director Foundation

Documentation Complete

Implementation Pending
