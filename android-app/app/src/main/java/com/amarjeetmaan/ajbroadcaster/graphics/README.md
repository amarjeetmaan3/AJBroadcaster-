# Graphics Package

Package:

com.amarjeetmaan.ajbroadcaster.graphics

---

## Purpose

The Graphics package is responsible for rendering all broadcast graphics used during live matches.

It provides television-style overlays, scoreboards, player information, sponsor graphics, match statistics, and animated visual elements.

The Graphics module receives data from other modules but never owns cricket logic itself.

---

## Responsibilities

The Graphics module manages:

- Score overlays
- Team information
- Player information
- Bowling statistics
- Batting statistics
- Match summary
- Tournament graphics
- Sponsor graphics
- Lower thirds
- Full screen graphics
- Popup graphics
- Animated graphics
- Branding

---

## Broadcast Graphics

Examples include:

- Live Score Overlay
- Toss Result
- Playing XI
- Current Partnership
- Required Run Rate
- Current Run Rate
- Over Summary
- Fall of Wicket
- Match Result
- Player of the Match
- Sponsor Banner

---

## Animation Graphics

Future animations:

- Four Animation
- Six Animation
- Wicket Animation
- Wide Animation
- No Ball Animation
- Free Hit Animation
- Fifty Celebration
- Hundred Celebration
- Hat-trick Animation
- Match Winner Animation

---

## Future Files

Examples:

- GraphicsManager.kt
- GraphicsController.kt
- GraphicsState.kt
- OverlayRenderer.kt
- ScoreboardRenderer.kt
- LowerThirdRenderer.kt
- SponsorRenderer.kt
- AnimationRenderer.kt
- GraphicsTheme.kt
- GraphicsAssets.kt

---

## Planned Features

### Overlay Engine

- Transparent overlays
- Multiple layers
- Dynamic positioning
- Safe area support
- Responsive layouts

---

### Theme System

Support:

- Light Theme
- Dark Theme
- Tournament Themes
- Team Colors
- Custom Branding

---

### Animation System

Support:

- Fade
- Slide
- Zoom
- Scale
- Rotation
- Particle Effects

---

### Asset Support

Graphics may use:

- PNG
- SVG
- Lottie Animations
- Video Clips
- Custom Fonts

---

## Data Sources

Graphics receive data from:

- Cricket Module
- Tournament Module
- Director Module
- Sponsor Module

Graphics should never modify this data.

---

## Architecture Rules

### Rule 1

No scoring calculations.

---

### Rule 2

No Firebase operations.

---

### Rule 3

Graphics must remain independent from Streaming implementation.

---

### Rule 4

Every graphic should be reusable.

---

### Rule 5

Rendering should be optimized for real-time broadcasting.

---

## Dependency Flow

Cricket Engine

+

Tournament Module

+

Director Module

↓

Graphics Package

↓

Overlay Module

↓

Live Broadcast

---

## Status

Graphics Foundation

Documentation Complete

Implementation Pending
