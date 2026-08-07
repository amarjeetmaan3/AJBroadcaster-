# UI Package

Package:

com.amarjeetmaan.ajbroadcaster.ui

---

# Purpose

The UI package contains all user interface components of AJ Broadcaster.

It is responsible for displaying information, collecting user input, and presenting application state using Jetpack Compose.

The UI layer must remain independent of business logic.

---

# Responsibilities

The UI module manages:

- Screens
- Components
- Widgets
- Dialogs
- Bottom Sheets
- Navigation UI
- Theme Integration
- State Rendering
- Loading States
- Error States
- Empty States

---

# UI Structure

Examples:

- screens/
- components/
- dialogs/
- bottomsheet/
- widgets/
- state/
- preview/

Each feature may maintain its own UI package.

---

# Screens

Examples:

- Home Screen
- Login Screen
- Dashboard
- Tournament
- Match Center
- Live Scoring
- Streaming
- Director Panel
- Settings
- Profile

---

# Components

Reusable UI components:

- Buttons
- Cards
- Toolbars
- Text Fields
- Dialogs
- Loading Views
- Empty Views
- Error Views
- Progress Indicators

---

# State Management

The UI observes state from ViewModels.

Typical flow:

ViewModel

↓

StateFlow

↓

Compose UI

↓

User Interaction

---

# Planned Features

Support:

- Responsive Layouts
- Tablet UI
- Foldable Device Support
- Landscape Layouts
- Accessibility
- Dynamic Themes
- Preview Support

---

# Future Files

Examples:

- BaseScreen.kt
- LoadingView.kt
- ErrorView.kt
- EmptyView.kt
- AppToolbar.kt
- PrimaryButton.kt
- ConfirmDialog.kt
- LoadingDialog.kt
- UiState.kt
- ScreenScaffold.kt

---

# Architecture Rules

## Rule 1

No business logic.

---

## Rule 2

No Firebase access.

---

## Rule 3

No repository access.

---

## Rule 4

UI communicates only with ViewModels.

---

## Rule 5

Keep composables small and reusable.

---

## Rule 6

State should be immutable whenever possible.

---

## Rule 7

Reusable components belong in the components package.

---

# Dependency Flow

User

↓

Compose UI

↓

ViewModel

↓

Domain Layer

↓

Data Layer

---

# Status

UI Foundation

Documentation Complete

Implementation Pending
