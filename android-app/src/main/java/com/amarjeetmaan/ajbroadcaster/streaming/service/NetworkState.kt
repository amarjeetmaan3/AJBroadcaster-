package com.amarjeetmaan.ajbroadcaster.streaming.service

enum class NetworkType {
    NONE,
    WIFI,
    MOBILE,
    ETHERNET,
    OTHER
}

data class NetworkState(
    val connected: Boolean = false,
    val type: NetworkType = NetworkType.NONE,
    val metered: Boolean = false
)
