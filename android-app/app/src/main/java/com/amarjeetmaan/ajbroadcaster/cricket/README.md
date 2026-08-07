# Cricket Package

Package:

com.amarjeetmaan.ajbroadcaster.cricket

---

# Purpose

The Cricket package is the heart of AJ Broadcaster.

It contains the complete cricket engine responsible for scoring, match management, innings control, player statistics, bowling logic, batting logic, tournament integration, and every official cricket rule supported by the application.

Every module that requires cricket information receives it from this package.

No other package should implement cricket rules.

---

# Responsibilities

The Cricket module manages:

- Match creation
- Match state
- Toss
- Team selection
- Playing XI
- Batting order
- Bowling order
- Innings
- Overs
- Balls
- Runs
- Extras
- Wickets
- Strike rotation
- Partnership
- Target calculation
- Match result
- Statistics
- Scoreboard data
- Undo
- Redo

---

# Cricket Formats

Supported formats:

- T5
- T10
- T15
- T20
- ODI
- Test Match

Future formats can be added without changing the architecture.

---

# Match Engine

Responsible for:

- Match initialization
- Match configuration
- Match state restoration
- Match completion
- Match reset
- Match export

---

# Batting Engine

Responsible for:

- New batsman
- Strike rotation
- Runs
- Boundaries
- Milestones
- Retirement
- Dismissals

---

# Bowling Engine

Responsible for:

- New bowler
- Bowling spell
- Over completion
- Maiden over
- Economy
- Bowling figures
- Bowling restrictions

---

# Extras Engine

Support:

- Wide
- No Ball
- Bye
- Leg Bye
- Penalty Runs

---

# Wicket Engine

Support:

- Bowled
- Caught
- LBW
- Run Out
- Stumped
- Hit Wicket
- Retired Out
- Timed Out
- Obstructing the Field

Future ICC dismissals can be added.

---

# Statistics Engine

Maintain:

- Batter statistics
- Bowler statistics
- Team statistics
- Match statistics
- Tournament statistics

---

# Match Calculations

Calculate:

- Current Run Rate
- Required Run Rate
- Target
- Remaining Runs
- Remaining Balls
- Partnership
- Extras
- Net Score

---

# Future Files

Examples:

- CricketManager.kt
- MatchEngine.kt
- MatchState.kt
- ScoreEngine.kt
- InningsManager.kt
- OverManager.kt
- BallManager.kt
- BattingManager.kt
- BowlingManager.kt
- ExtrasManager.kt
- WicketManager.kt
- PartnershipManager.kt
- StatisticsManager.kt
- TargetCalculator.kt
- DLSCalculator.kt
- UndoManager.kt
- MatchValidator.kt

---

# Planned Features

Support:

- Unlimited Undo
- Unlimited Redo
- Ball History
- Match Timeline
- Automatic Statistics
- Automatic Highlights
- Live Match Summary
- Auto Save
- Crash Recovery

---

# Architecture Rules

## Rule 1

This is the only package allowed to contain cricket rules.

---

## Rule 2

UI must never calculate cricket values.

---

## Rule 3

Graphics package only displays data received from Cricket.

---

## Rule 4

Firebase stores cricket data but never calculates cricket logic.

---

## Rule 5

Streaming module never modifies cricket state.

---

## Rule 6

Every scoring action must be reversible through Undo.

---

## Rule 7

Every ball must generate a complete immutable event record.

---

## Dependency Flow

User Input

↓

Cricket Package

↓

Tournament Package

↓

Graphics Package

↓

Overlay Package

↓

Streaming Package

↓

Live Broadcast

---

# Status

Cricket Engine Foundation

Documentation Complete

Implementation Pending
