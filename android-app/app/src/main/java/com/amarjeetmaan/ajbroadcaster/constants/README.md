# Constants Package

Package:

com.amarjeetmaan.ajbroadcaster.constants

---

## Purpose

The Constants package is the single source of truth for all constant values used throughout the AJ Broadcaster application.

No module should hardcode repeated strings, IDs, keys, paths, versions, or configuration values.

---

## Architecture Rules

### 1. No Business Logic

This package contains constants only.

Never place:

- Functions
- Classes with logic
- Database operations
- Firebase code
- Compose code

---

### 2. Single Responsibility

Each file has one responsibility.

Example:

AppConstants.kt

Application-wide constants only.

FirebaseConstants.kt

Firebase node names only.

PermissionConstants.kt

Android permissions only.

PreferenceConstants.kt

SharedPreferences/DataStore keys only.

IntentConstants.kt

Intent Extra keys only.

NavigationConstants.kt

Navigation configuration only.

BuildConstants.kt

Build configuration values only.

---

### 3. Never Hardcode

Wrong

database.child("matches")

Correct

database.child(FirebaseConstants.MATCHES)

---

Wrong

intent.putExtra("match_id", id)

Correct

intent.putExtra(IntentConstants.EXTRA_MATCH_ID, id)

---

### 4. Easy Maintenance

Changing a Firebase node or preference key should require editing one file only.

---

### 5. Future Expansion

As AJ Broadcaster grows, new constant files may be added, for example:

NetworkConstants.kt

ApiConstants.kt

GraphicsConstants.kt

AnimationConstants.kt

CameraConstants.kt

StreamingConstants.kt

TournamentConstants.kt

CricketConstants.kt

OverlayConstants.kt

These should only be created when needed.

---

## Current Files

AppConstants.kt

BuildConstants.kt

FirebaseConstants.kt

IntentConstants.kt

NavigationConstants.kt

PreferenceConstants.kt

PermissionConstants.kt

README.md

---

## Dependency Rule

Every package in the application may depend on Constants.

Constants must never depend on feature packages.

Allowed

Feature → Constants

Not Allowed

Constants → Cricket

Constants → Firebase

Constants → Streaming

Constants → UI

---

## Status

Package Status:

Completed ✅

Ready for production development.
