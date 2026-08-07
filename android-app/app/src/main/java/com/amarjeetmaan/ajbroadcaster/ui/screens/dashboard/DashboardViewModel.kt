package com.amarjeetmaan.ajbroadcaster.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for DashboardScreen.
 *
 * Will manage dashboard data,
 * statistics, recent matches,
 * and quick actions.
 */
@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    /**
     * Refreshes dashboard content.
     *
     * Repository integration will
     * be added in future phases.
     */
    fun refreshDashboard() {
        // Reserved for future implementation.
    }
}
