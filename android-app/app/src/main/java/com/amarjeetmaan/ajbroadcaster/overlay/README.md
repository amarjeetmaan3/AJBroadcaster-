# Overlay Package

Package:

com.amarjeetmaan.ajbroadcaster.overlay

---

## Purpose

The Overlay package is responsible for rendering the final transparent broadcast layer displayed above the live camera preview and included in the live stream.

It combines graphics, animations, scoreboards, timers, sponsor elements, and other broadcast visuals into one synchronized output.

The Overlay package does not generate cricket data or graphics. It only renders them.

---

## Responsibilities

The Overlay module manages:

- Transparent overlays
- Scoreboard rendering
- Live match information
- Timer display
- Team names
- Player information
- Sponsor banners
- Lower thirds
- Full-screen graphics
- Animation rendering
- Overlay positioning
- Layer management

---

## Overlay Layers

The broadcast overlay consists of multiple independent layers.

Examples:

Layer 1
Background

Layer 2
Camera Preview

Layer 3
Scoreboard

Layer 4
Graphics

Layer 5
Animations

Layer 6
Sponsor Graphics

Layer 7
Emergency Messages

Each layer can be enabled or disabled independently.

---

## Future Files

Examples:

- OverlayManager.kt
- OverlayController.kt
- OverlayRenderer.kt
- OverlayState.kt
- OverlayLayer.kt
- OverlayLayout.kt
- OverlayPosition.kt
- OverlayVisibility.kt
- OverlaySettings.kt
- SafeAreaManager.kt

---

## Planned Features

### Score Overlay

Display:

- Team Names
- Team Logos
- Current Score
- Overs
- Run Rate
- Required Run Rate
- Target
- Batter Names
- Bowler Name

---

### Information Overlay

Display:

- Toss Winner
- Match Status
- Current Partnership
- Required Runs
- Required Balls
- Powerplay
- Match Result

---

### Sponsor Overlay

Display:

- Sponsor Logo
- Sponsor Banner
- Sponsor Animation
- Full Screen Advertisement

---

### Layer Control

Support:

- Show Layer
- Hide Layer
- Move Layer
- Resize Layer
- Lock Layer
- Opacity Control

---

## Safe Area

All overlays should respect broadcast safe areas.

No important information should be rendered outside the visible television-safe region.

---

## Architecture Rules

### Rule 1

No cricket calculations.

---

### Rule 2

No Firebase operations.

---

### Rule 3

Overlay receives graphics from Graphics module.

---

### Rule 4

Overlay receives animations from Animation module.

---

### Rule 5

Overlay should never modify graphics data.

---

### Rule 6

Overlay must support multiple screen resolutions.

Examples:

- 720p
- 1080p
- 1440p
- 4K

---

### Rule 7

Rendering should be optimized for real-time broadcasting.

---

## Dependency Flow

Camera

+

Graphics

+

Animation

↓

Overlay Package

↓

Streaming Module

↓

Live Broadcast

---

## Status

Overlay Foundation

Documentation Complete

Implementation Pending
