# Utils Package

Package:

com.amarjeetmaan.ajbroadcaster.utils

---

## Purpose

The Utils package contains reusable helper classes that can be used anywhere in the application.

Utility classes should be independent of any feature module.

They should perform generic tasks that are useful across multiple parts of the app.

Examples include:

- Date & Time formatting
- String manipulation
- Validation
- Number formatting
- File utilities
- Permission helpers

---

## Current Files

### DateTimeUtils.kt

Provides date and time helper methods.

Responsibilities

- Format dates
- Format times
- Format date & time
- Get current system time

---

### StringUtils.kt

Provides reusable String helper methods.

Responsibilities

- Null-safe string handling
- Trim text
- Capitalize text
- Numeric checks
- Length limiting

---

### ValidationUtils.kt

Provides reusable validation methods.

Responsibilities

- Required field validation
- Email validation
- Mobile number validation
- URL validation
- Name validation
- Length validation

---

## Future Utility Files

As AJ Broadcaster grows, this package may include:

- NumberUtils.kt
- FileUtils.kt
- PermissionUtils.kt
- ImageUtils.kt
- JsonUtils.kt
- NetworkUtils.kt
- DeviceUtils.kt
- ScreenUtils.kt
- StorageUtils.kt
- ColorUtils.kt

Only add a utility class when it contains reusable functionality.

---

## Architecture Rules

### Rule 1

Utility classes must not contain business logic.

Business rules belong in the Domain layer.

---

### Rule 2

Utility classes should be reusable.

If a helper is only used by one feature, keep it inside that feature instead.

---

### Rule 3

Avoid Android dependencies unless necessary.

Pure Kotlin utilities are preferred.

---

### Rule 4

Do not store application state inside utility objects.

Utilities should remain stateless.

---

### Rule 5

Keep methods small and focused.

One function should perform one task.

---

## Dependency Flow

Feature

↓

Utils

Utilities never depend on Feature modules.

---

## Status

Utils Foundation

Completed
