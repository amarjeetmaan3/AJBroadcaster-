# Data Package

Package:

com.amarjeetmaan.ajbroadcaster.data

---

## Purpose

The Data package contains all data models used throughout the AJ Broadcaster application.

These models represent the application's data structure and are shared between Firebase, Repositories, ViewModels, and the UI.

The package does not contain business logic.

---

## Current Files

### BaseModel.kt

The parent model for all application data.

Common fields:

- id
- createdAt
- updatedAt
- isDeleted

Every future model should inherit from BaseModel whenever appropriate.

---

## Future Models

This package will eventually contain models such as:

### Cricket

- Match.kt
- Innings.kt
- Over.kt
- Ball.kt
- Score.kt
- Wicket.kt
- Partnership.kt

### Tournament

- Tournament.kt
- TournamentRule.kt
- PointTable.kt
- Fixture.kt

### Teams

- Team.kt
- TeamOwner.kt

### Players

- Player.kt
- PlayerStatistics.kt
- PlayerAuction.kt

### Graphics

- ScoreOverlay.kt
- LowerThird.kt
- MatchSummary.kt

### Streaming

- StreamSession.kt
- CameraSource.kt

### Director

- DirectorCommand.kt
- DirectorState.kt

### Sponsors

- Sponsor.kt
- Advertisement.kt

### Settings

- UserSettings.kt
- AppConfiguration.kt

---

## Architecture Rules

### Rule 1

Models contain data only.

No business logic.

---

### Rule 2

Avoid Android framework classes inside models.

Keep models serializable and Firebase-friendly.

---

### Rule 3

Use default values for every property.

This is required for Firebase object deserialization.

Example

var teamName: String = ""

NOT

lateinit var teamName: String

---

### Rule 4

Keep models immutable whenever practical.

Prefer data classes unless inheritance requires otherwise.

---

### Rule 5

Never place Repository or Firebase code inside models.

Models represent data only.

---

## Dependency Flow

Firebase

↓

Repository

↓

Data Models

↓

ViewModel

↓

Compose UI

---

## Status

Data Foundation

Completed
