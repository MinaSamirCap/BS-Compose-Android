package com.mmd.compose_bs_android.task9

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mmd.compose_bs_android.task9.components.SingleTabBadgeItem
import com.mmd.compose_bs_android.task9.models.TabUiModel
import com.mmd.compose_bs_android.task9.tabs.DialogsTab
import com.mmd.compose_bs_android.task9.tabs.ProgressBarsTab
import com.mmd.compose_bs_android.task9.tabs.SheetsTab

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowSample() {

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    val tabItems = remember {
        TabUiModel.getTabItems()
    }

    val pagerState = rememberPagerState {
        tabItems.size
    }

    /// we have a state for selected item and pager state ...
    /// but if we clicked on tab that will not affect the pager state
    /// also, if we swiped that will not affect the selected item of tab.

    /// So, we need to configure them or make each one know the other ..
    /// using LaunchEffect ...

    // connect selected tab index with pager state
    LaunchedEffect(selectedItem) {
        pagerState.animateScrollToPage(selectedItem)
    }

    // connect pager state with selected tab index
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedItem = pagerState.currentPage
        }
    }




    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TabRow(
            selectedTabIndex = selectedItem,
            backgroundColor = Color.Yellow,
            contentColor = Color.Black
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

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->

            when (index) {
                0 -> {
                    SheetsTab()
                }

                1 -> {
                    DialogsTab()
                }

                2 -> {
                    ProgressBarsTab()
                }
            }

        }

    }
}


@Preview
@Composable
fun TabRowSampleDemo() {
    TabRowSample()
}