# Theme Package

Package:

com.amarjeetmaan.ajbroadcaster.theme

---

# Purpose

The Theme package defines the visual identity of AJ Broadcaster.

It centralizes application colors, typography, shapes, spacing, dimensions, and Material Design configuration to ensure a consistent user experience across every screen.

The Theme package contains design configuration only.

It must never contain business logic.

---

# Responsibilities

The Theme module manages:

- Color System
- Typography
- Material Theme
- Shapes
- Dimensions
- Spacing
- Elevation
- Icons
- Design Tokens
- Light Theme
- Dark Theme

---

# Current Files

- Color.kt
- Type.kt
- Theme.kt

Future files:

- Shape.kt
- Dimensions.kt
- Spacing.kt
- Elevation.kt
- IconSet.kt
- ThemePreview.kt

---

# Color System

Responsible for:

- Primary Colors
- Secondary Colors
- Tertiary Colors
- Error Colors
- Background Colors
- Surface Colors
- Broadcast Colors
- Overlay Colors

Future support:

- Team Colors
- Tournament Themes
- Sponsor Themes

---

# Typography

Defines:

- Display Styles
- Headlines
- Titles
- Body Text
- Labels

Future support:

- Digital Score Fonts
- Hindi Fonts
- Broadcast Fonts

---

# Material Theme

Responsible for:

- Material 3 Theme
- Dynamic Colors
- Dark Mode
- Light Mode
- System Theme

---

# Planned Features

Support:

- Multiple Theme Packs
- Broadcast Themes
- Dynamic Branding
- Team-Based Themes
- Tournament Themes
- Accessibility Themes

---

# Future Files

Examples:

- Shape.kt
- Dimensions.kt
- Spacing.kt
- ThemeManager.kt
- ThemeExtensions.kt
- ThemePreview.kt

---

# Architecture Rules

## Rule 1

No business logic.

---

## Rule 2

No Firebase code.

---

## Rule 3

No repository access.

---

## Rule 4

Theme values should be reused throughout the application.

---

## Rule 5

Avoid hardcoded colors inside UI screens.

---

## Rule 6

Support both Light and Dark themes.

---

## Rule 7

All visual constants should originate from this package.

---

# Dependency Flow

Compose UI

↓

Material Theme

↓

Theme Package

↓

Colors

Typography

Shapes

Dimensions

---

# Status

Theme Foundation

Color.kt Complete

Type.kt Complete

Theme.kt Complete

Future Expansion Planned
