# AJ Broadcaster Android Application

## Overview

This directory contains the complete Android application for the AJ Broadcaster project.

AJ Broadcaster is a professional Android-based cricket broadcasting system designed to perform live scoring, graphics rendering, camera management, live streaming, tournament management, and remote direction using Android devices.

---

## Technology Stack

- Kotlin
- Jetpack Compose
- Material Design 3
- CameraX
- Firebase Realtime Database
- Firebase Authentication
- Android Jetpack
- GitHub

---

## Project Structure

```text
android-app/
├── app/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── .gitignore
└── README.md
```

---

## Architecture

The Android application follows a modular architecture.

Current foundation packages:

- app
- theme
- navigation
- constants
- core

Additional packages will be added gradually as the project develops.

---

## Development Rules

- Never duplicate business logic.
- Keep packages modular.
- Maintain clean architecture.
- One responsibility per class.
- Never redesign the foundation without architectural review.

---

## Current Status

Foundation Version: **1.0**
