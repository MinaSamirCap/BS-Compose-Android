package com.mmd.compose_bs_android.task8.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mmd.compose_bs_android.task8.models.NavigationDrawerUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScope.ItemsNavDrawerBody(
    drawerNavItems: List<NavigationDrawerUiModel>,
    selectedItem: Int,
    onItemSelect: ((Int) -> Unit)? = null
) {
    Column(
        modifier = Modifier.weight(1f)
    ) {
        drawerNavItems.forEachIndexed { index, item ->
            val isSelected = index == selectedItem
            NavigationDrawerItem(
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                label = { Text(text = item.txt) },
                badge = {
                    if (item.badgeCount != null) {
                        Badge {
                            Text(text = item.badgeCount.toString())
                        }
                    } else if (item.hasSomethingNew) {
                        Badge()
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.iconSelected else item.icon,
                        contentDescription = null
                    )
                },
                selected = isSelected,
                onClick = {
                    item.resetBadges()
                    onItemSelect?.invoke(index)
                }
            )
        }
    }
}

@Preview
@Composable
fun ItemsNavDrawerBodyPreview() {
    Column {
        ItemsNavDrawerBody(
            NavigationDrawerUiModel.getMainNavDrawerItems(),
            0
        )
    }
}