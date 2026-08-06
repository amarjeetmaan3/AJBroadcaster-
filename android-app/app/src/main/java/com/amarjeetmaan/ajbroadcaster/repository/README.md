# Repository Package

Package:

com.amarjeetmaan.ajbroadcaster.repository

---

## Purpose

The Repository package is responsible for managing all data operations in the application.

Repositories act as the bridge between the application's business logic (Domain layer) and the data sources.

A repository may communicate with:

- Firebase Realtime Database
- Firebase Authentication
- Local Storage
- Cache
- File System
- Remote APIs (future)

The rest of the application should never communicate directly with these data sources.

---

## Current Files

### BaseRepository.kt

The base class for every repository.

Responsibilities

- Execute operations safely
- Catch exceptions
- Log errors
- Return AppResult instead of throwing exceptions

All repositories must inherit from this class.

---

## Future Repository Files

Examples include:

- AuthRepository.kt
- UserRepository.kt
- TournamentRepository.kt
- MatchRepository.kt
- TeamRepository.kt
- PlayerRepository.kt
- SponsorRepository.kt
- StreamRepository.kt
- GraphicsRepository.kt
- OverlayRepository.kt
- CameraRepository.kt
- SettingsRepository.kt

These files will be added as the project grows.

---

## Architecture Rules

### Rule 1

Repositories never contain UI code.

Do NOT import:

- Compose
- Activities
- Fragments

---

### Rule 2

Repositories should return AppResult.

Never return raw Exceptions.

---

### Rule 3

Repositories should not know about Screens.

They only provide data.

---

### Rule 4

Business rules belong in the Domain layer.

Repositories should focus only on retrieving, saving, updating, and deleting data.

---

### Rule 5

All repositories should extend BaseRepository.

This guarantees consistent logging and exception handling.

---

## Dependency Flow

Compose Screen

↓

ViewModel

↓

Repository

↓

Firebase / Local Storage / API

---

## Status

Repository Foundation

Completed
