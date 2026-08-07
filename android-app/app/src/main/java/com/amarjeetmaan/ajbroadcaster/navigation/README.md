# Navigation Package

Package:

com.amarjeetmaan.ajbroadcaster.navigation

---

# Purpose

The Navigation package manages screen navigation throughout AJ Broadcaster.

It provides a centralized navigation architecture based on Jetpack Compose Navigation.

Every screen transition in the application must pass through this package.

Navigation must remain independent of business logic and data operations.

---

# Responsibilities

The Navigation module manages:

- Navigation Graph
- Route Definitions
- Screen Navigation
- Back Stack
- Deep Links
- Navigation Arguments
- Nested Navigation Graphs
- Authentication Navigation
- Feature Navigation

---

# Navigation Components

Current files:

- AppRoutes.kt
- AppNavigation.kt
- NavigationActions.kt

Future files:

- AuthNavigation.kt
- TournamentNavigation.kt
- StreamingNavigation.kt
- DirectorNavigation.kt
- SettingsNavigation.kt
- NavigationExtensions.kt

---

# Route Management

All route names must be defined inside:

AppRoutes.kt

No screen should hardcode route strings.

---

# Navigation Actions

NavigationActions.kt is responsible for:

- Navigate
- Navigate Back
- Clear Back Stack
- Logout Navigation
- Single Top Navigation
- Restore State

---

# Navigation Graph

Root Graph

↓

Authentication

↓

Dashboard

↓

Feature Modules

↓

Settings

Each feature may own its own nested navigation graph.

---

# Deep Links

Future support:

- Tournament Links
- Match Links
- Player Links
- Team Links
- Broadcast Links

---

# Planned Features

Support:

- Nested Navigation
- Animated Navigation
- Deep Linking
- Multi-Backstack
- Tablet Navigation
- Multi-Window Navigation

---

# Architecture Rules

## Rule 1

Navigation package contains navigation only.

---

## Rule 2

No business logic.

---

## Rule 3

No Firebase operations.

---

## Rule 4

No repository access.

---

## Rule 5

Screens should navigate through NavigationActions instead of directly manipulating NavController.

---

## Rule 6

Every feature should expose its own navigation graph as the application grows.

---

## Rule 7

Keep AppNavigation.kt as the root graph only.

Feature graphs should be modular.

---

# Dependency Flow

MainActivity

↓

AppNavigation

↓

Feature Navigation

↓

Feature Screens

---

# Status

Navigation Foundation

Documentation Complete

Implementation Complete (Foundation)

Future Expansion Planned
