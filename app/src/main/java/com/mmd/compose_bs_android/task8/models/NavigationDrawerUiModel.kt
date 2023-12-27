package com.mmd.compose_bs_android.task8.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerUiModel(
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val txt: String,
    var hasSomethingNew: Boolean = false,
    var badgeCount: Int? = null
) {
    fun resetBadges() {
        hasSomethingNew = false
        badgeCount = null
    }

    companion object {
        fun getMainNavDrawerItems() = listOf(
            NavigationDrawerUiModel(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Home"
            ),
            NavigationDrawerUiModel(
                icon = Icons.Outlined.Email,
                iconSelected = Icons.Filled.Email,
                txt = "Messages",
                badgeCount = 12
            ),
            NavigationDrawerUiModel(
                icon = Icons.Outlined.Settings,
                iconSelected = Icons.Filled.Settings,
                txt = "Settings",
                hasSomethingNew = true
            )
        )
    }
}