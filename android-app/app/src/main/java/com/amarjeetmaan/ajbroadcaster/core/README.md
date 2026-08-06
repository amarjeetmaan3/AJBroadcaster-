# Core Package

Package:

com.amarjeetmaan.ajbroadcaster.core

---

## Purpose

The Core package contains the application's shared foundation.

Everything inside this package can be used by every other module in the project.

No feature-specific business logic should ever be placed here.

Examples of feature packages:

- auth
- cricket
- tournament
- streaming
- graphics
- overlay
- camera

Those packages may use Core, but Core must never depend on them.

---

## Files

### Logger.kt

Centralized logging utility.

Responsibilities

- Debug logging
- Info logging
- Warning logging
- Error logging

Uses BuildConfig.DEBUG so logs are automatically disabled in Release builds.

---

### Resource.kt

UI state wrapper.

Used by ViewModels.

States

- Loading
- Success
- Error

Compose screens should observe Resource objects.

---

### AppResult.kt

Repository and Domain result wrapper.

Used internally by repositories and use cases.

States

- Success
- Failure

Repositories should return AppResult instead of throwing exceptions.

---

### DispatcherProvider.kt

Coroutine dispatcher abstraction.

Provides

- Main
- IO
- Default
- Unconfined

Never hardcode Dispatchers.IO or Dispatchers.Main directly inside repositories.

---

### DefaultDispatcherProvider.kt

Production implementation of DispatcherProvider.

Returns Kotlin Coroutine Dispatchers.

---

### ErrorHandler.kt

Converts exceptions into safe user-readable messages.

Example

IOException

↓

"Please check your internet connection."

---

### AppCoroutineScope.kt

Global application CoroutineScope.

Used only for long-running tasks.

Examples

- Background synchronization
- Streaming engine
- Upload manager
- Persistent logging

Do NOT use this for UI work.

ViewModels must continue using viewModelScope.

---

## Architecture Rules

### Rule 1

Core never imports feature packages.

Allowed

core ← auth

core ← streaming

core ← cricket

Not allowed

core → auth

core → cricket

---

### Rule 2

No UI code.

No Compose Screens.

No Activities.

No Fragments.

---

### Rule 3

No Firebase code.

Firebase belongs inside the firebase package.

---

### Rule 4

Keep utilities reusable.

If another module can reuse it,

it probably belongs inside Core.

---

### Rule 5

Keep Core lightweight.

Avoid adding unnecessary helper classes.

---

## Dependency Flow

App

↓

Feature Modules

↓

Repository

↓

Core

Core is the lowest reusable layer.

Nothing below Core.

---

## Status

Core Foundation

Completed
