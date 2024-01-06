package com.mmd.compose_bs_android.task8

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.MainActivity
import com.mmd.compose_bs_android.task8.components.ShrekNavDrawerHeader
import com.mmd.compose_bs_android.task8.models.NavigationDrawerUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RailNavDrawerSample(activity: MainActivity? = null) {

    //DetermineScreenSizeType(activity)
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    val drawerNavItems = remember {
        NavigationDrawerUiModel.getMainNavDrawerItems()
    }

    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


    Scaffold(
        modifier = Modifier
            .padding(start = 80.dp)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(text = "Rail Nav")
                })
        }
    ) { contentPadding ->
        // Screen content

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            items(150) {
                Text(
                    text = "Item: $it",
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }


    NavigationRail(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .shadow(elevation = 10.dp),
        header = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }
            FloatingActionButton(
                onClick = { },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }

            Spacer(modifier = Modifier.height(10.dp))

            ShrekNavDrawerHeader(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Bottom)
        ) {
            drawerNavItems.forEachIndexed { index, item ->

                val isSelected = index == selectedItem
                NavigationRailItem(
                    selected = isSelected,
                    onClick = {
                        item.resetBadges()
                        selectedItem = index
                    },
                    label = {
                        Text(text = item.txt)
                    },
                    icon = {
                        SingleIconBadgeItem(item = item, isSelected = isSelected)
                    })

            }
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
private fun DetermineScreenSizeType(activity: MainActivity?) {
    val windowClass = calculateWindowSizeClass(activity = activity!!)
    if (windowClass.widthSizeClass != WindowWidthSizeClass.Compact) {
        /// Bla Bla Bla
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SingleIconBadgeItem(item: NavigationDrawerUiModel, isSelected: Boolean) {
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
fun RailNavDrawerSamplePreview() {
    RailNavDrawerSample()
}


/// references ...
// https://www.youtube.com/watch?v=BezaAlslYDQ&list=PLQkwcJG4YTCT1LkjokmzZUFFyFVVWPuKk&index=9&ab_channel=PhilippLackner
// https://www.droidcon.com/2022/12/19/creating-a-collapsing-topappbar-with-jetpack-compose/