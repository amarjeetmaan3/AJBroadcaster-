# Authentication Package

Package:

com.amarjeetmaan.ajbroadcaster.auth

---

## Purpose

The Authentication package manages user identity, login, logout, session management, and access permissions.

It is responsible for verifying users before allowing access to protected features of the AJ Broadcaster application.

This package should never contain UI for other features such as scoring or streaming.

---

## Responsibilities

Authentication module handles:

- User Login
- User Logout
- User Registration
- Password Reset
- Session Management
- User Verification
- User Roles
- Permission Checking
- Remember Login
- Auto Login

---

## Planned User Roles

The application will support multiple user roles.

Examples:

- Super Admin
- Tournament Admin
- Director
- Scorer
- Camera Operator
- Graphics Operator
- Commentator
- Viewer

Each role will have different permissions.

---

## Future Files

Examples:

- LoginRepository.kt
- AuthManager.kt
- SessionManager.kt
- UserRole.kt
- PermissionManager.kt
- LoginUseCase.kt
- LogoutUseCase.kt
- CurrentUser.kt
- AuthViewModel.kt

---

## Authentication Flow

Application Start

↓

Check Saved Session

↓

If Logged In

↓

Open Dashboard

Else

↓

Open Login Screen

↓

Authenticate User

↓

Save Session

↓

Open Dashboard

---

## Architecture Rules

### Rule 1

Authentication must not depend on cricket modules.

---

### Rule 2

Permissions should be checked before opening restricted screens.

---

### Rule 3

Authentication state should be available globally.

---

### Rule 4

Never store passwords locally.

Only secure authentication tokens or encrypted session data should be stored.

---

### Rule 5

Future authentication provider:

- Firebase Authentication

Additional providers may be added later if required.

---

## Status

Authentication Foundation

Documentation Complete

Implementation Pending
