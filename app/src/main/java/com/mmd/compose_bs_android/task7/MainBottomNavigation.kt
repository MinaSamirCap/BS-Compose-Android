package com.mmd.compose_bs_android.task7

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.R

@Composable
fun MainBottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {

        val unselectedColor = colorResource(id = R.color.teal_700)
        val selectedColor = MaterialTheme.colorScheme.primary

        items.forEachIndexed { index, item ->
            val isSelected = index == selected
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClick(index) },
                icon = {
                    SingleIconBadgeItem(item = item, isSelected)
                },
                label = {
                    Text(
                        text = item.txt,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedColor,
                    unselectedIconColor = unselectedColor,
                    selectedTextColor = selectedColor,
                    unselectedTextColor = unselectedColor,
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SingleIconBadgeItem(item: BottomNavigationItem, isSelected: Boolean) {
    val icon = if (isSelected) item.iconSelected else item.icon
    BadgedBox(badge = {
        if (item.badgeCount != null) {
            Badge {
                Text(text = item.badgeCount.toString())
            }
        } else if (item.hasSomethingNew) {
            Badge()
        }

    }) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
        )
    }
}

data class BottomNavigationItem(
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
        fun getMainNavItems() = listOf(
            BottomNavigationItem(
                icon = Icons.Outlined.Home,
                iconSelected = Icons.Filled.Home,
                txt = "Home"
            ),
            BottomNavigationItem(
                icon = Icons.Outlined.Email,
                iconSelected = Icons.Filled.Email,
                txt = "Messages",
                badgeCount = 12
            ),
            BottomNavigationItem(
                icon = Icons.Outlined.Settings,
                iconSelected = Icons.Filled.Settings,
                txt = "Settings",
                hasSomethingNew = true
            )
        )
    }
}

@Preview
@Composable
fun MainBottomNavigationPreview() {
    MainBottomNavigation(
        items = BottomNavigationItem.getMainNavItems(),
        selected = 0,
        onItemClick = {}
    )
}