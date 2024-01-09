package com.mmd.compose_bs_android.task9.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class TabUiModel(
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
        fun getTabItems() = listOf(
            TabUiModel(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Home"
            ),
            TabUiModel(
                icon = Icons.Outlined.ShoppingCart,
                iconSelected = Icons.Filled.ShoppingCart,
                txt = "Browse",
                badgeCount = 12
            ),
            TabUiModel(
                icon = Icons.Outlined.AccountCircle,
                iconSelected = Icons.Filled.AccountCircle,
                txt = "Settings",
                hasSomethingNew = true
            )
        )

        fun getScrollableTabItems() = listOf(
            TabUiModel(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Home"
            ),
            TabUiModel(
                icon = Icons.Outlined.ShoppingCart,
                iconSelected = Icons.Filled.ShoppingCart,
                txt = "Browse",
                badgeCount = 12
            ),
            TabUiModel(
                icon = Icons.Outlined.AccountCircle,
                iconSelected = Icons.Filled.AccountCircle,
                txt = "Settings",
                hasSomethingNew = true
            ),
            TabUiModel(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Account"
            ),
            TabUiModel(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Cart"
            ),
            TabUiModel(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Profile"
            ),
            TabUiModel(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Home2"
            )
        )
    }
}