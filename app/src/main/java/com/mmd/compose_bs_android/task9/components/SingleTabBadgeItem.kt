package com.mmd.compose_bs_android.task9.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.task9.models.TabUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleTabBadgeItem(item: TabUiModel, isSelected: Boolean) {
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

@Preview
@Composable
fun SingleTabBadgeItemPreview() {
    SingleTabBadgeItem(item = TabUiModel.getTabItems().first(), isSelected = true)
}

@Preview
@Composable
fun SingleTabBadgeItemPreview2() {
    SingleTabBadgeItem(item = TabUiModel.getTabItems().last(), isSelected = false)
}