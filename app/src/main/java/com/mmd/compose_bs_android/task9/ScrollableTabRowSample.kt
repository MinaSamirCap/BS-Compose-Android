package com.mmd.compose_bs_android.task9

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.task9.components.SingleTabBadgeItem
import com.mmd.compose_bs_android.task9.models.TabUiModel
import com.mmd.compose_bs_android.task9.tabs.ScaffoldSheetsTab

@Composable
fun ScrollableTabRowSample() {

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    val tabItems = remember {
        TabUiModel.getScrollableTabItems()
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        ScrollableTabRow(
            selectedTabIndex = selectedItem,
            backgroundColor = Color.Yellow,
            contentColor = Color.Black,
            edgePadding = 120.dp
        ) {
            tabItems.forEachIndexed { index, item ->
                val isSelected = index == selectedItem
                Tab(
                    selected = isSelected,
                    onClick = {
                        item.resetBadges()
                        selectedItem = index
                    },
                    text = {
                        Text(text = item.txt)
                    },
                    icon = {
                        SingleTabBadgeItem(item = item, isSelected = isSelected)
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {

            when (selectedItem) {

                0 -> {
                    ScaffoldSheetsTab()
                }

                1 -> {

                }

                2 -> {

                }

                else -> {
                    Text(text = tabItems[selectedItem].txt)
                }

            }


        }

    }
}


@Preview
@Composable
fun ScrollableTabRowSampleDemo() {
    ScrollableTabRowSample()
}