# Domain Package

Package:

com.amarjeetmaan.ajbroadcaster.domain

---

## Purpose

The Domain package contains the application's business logic.

It sits between the Repository layer and the ViewModel layer.

The Domain layer decides **what should happen**, while the Repository layer only knows **how to get or save data**.

---

## Responsibilities

The Domain layer is responsible for:

- Business rules
- Match logic
- Tournament rules
- Player eligibility
- Score calculations
- Statistics calculations
- Validation beyond simple field checks
- Cricket engine logic

---

## Future Files

As AJ Broadcaster grows, this package will contain use cases such as:

Authentication

- LoginUseCase.kt
- LogoutUseCase.kt

Tournament

- CreateTournamentUseCase.kt
- UpdateTournamentUseCase.kt
- DeleteTournamentUseCase.kt

Teams

- CreateTeamUseCase.kt
- UpdateTeamUseCase.kt

Players

- RegisterPlayerUseCase.kt
- AuctionPlayerUseCase.kt

Matches

- StartMatchUseCase.kt
- EndMatchUseCase.kt
- CreateSuperOverUseCase.kt
- TossUseCase.kt

Scoring

- AddBallUseCase.kt
- UndoBallUseCase.kt
- RotateStrikeUseCase.kt
- CalculateRunRateUseCase.kt
- CalculateRequiredRunRateUseCase.kt

Broadcast

- StartStreamingUseCase.kt
- StopStreamingUseCase.kt
- ShowGraphicUseCase.kt
- HideGraphicUseCase.kt

Director

- ChangeCameraUseCase.kt
- TriggerReplayUseCase.kt

---

## Architecture Rules

### Rule 1

No UI code.

Never import:

- Compose
- Activity
- Fragment

---

### Rule 2

No Firebase code.

Repositories communicate with Firebase.

Domain communicates only with Repositories.

---

### Rule 3

One UseCase = One Responsibility.

Example

StartMatchUseCase

should only start a match.

It should not update sponsors, graphics, or tournament tables.

---

### Rule 4

Business rules belong here.

Example

✓ Super Over rules

✓ Powerplay rules

✓ Wide ball
