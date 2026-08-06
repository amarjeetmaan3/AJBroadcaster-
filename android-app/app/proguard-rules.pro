# ==========================================================
# AJ Broadcaster - ProGuard Rules
# ==========================================================
# Currently, code shrinking and obfuscation are disabled
# in the Release build. This file serves as the foundation
# for future optimization rules.

# ----------------------------------------------------------
# Keep Kotlin Metadata
# ----------------------------------------------------------
-keep class kotlin.Metadata { *; }

# ----------------------------------------------------------
# Firebase
# ----------------------------------------------------------
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# ----------------------------------------------------------
# CameraX
# ----------------------------------------------------------
-keep class androidx.camera.** { *; }
-dontwarn androidx.camera.**

# ----------------------------------------------------------
# Jetpack Compose
# ----------------------------------------------------------
-keep class androidx.compose.** { *; }

# ----------------------------------------------------------
# Coroutines
# ----------------------------------------------------------
-dontwarn kotlinx.coroutines.**

# ----------------------------------------------------------
# Project Packages
# ----------------------------------------------------------
-keep class com.amarjeetmaan.ajbroadcaster.** { *; }

# ----------------------------------------------------------
# Future Rules
# ----------------------------------------------------------
# Add R8/ProGuard rules here when introducing:
# - FFmpeg
# - WebRTC
# - ExoPlayer
# - TensorFlow Lite
# - ML Kit
# - Third-party SDKs
