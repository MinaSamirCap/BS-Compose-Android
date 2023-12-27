package com.mmd.compose_bs_android.task8

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.task8.components.ItemsNavDrawerBody
import com.mmd.compose_bs_android.task8.components.ShrekNavDrawerHeader
import com.mmd.compose_bs_android.task8.components.WithoutPaddingNavDrawerItem
import com.mmd.compose_bs_android.task8.models.NavigationDrawerUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissibleNavDrawerSample() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    val drawerNavItems = remember {
        NavigationDrawerUiModel.getMainNavDrawerItems()
    }

    DismissibleNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DismissibleDrawerSheet {

                ShrekNavDrawerHeader()

                Spacer(modifier = Modifier.height(20.dp))

                ItemsNavDrawerBody(
                    drawerNavItems,
                    selectedItem
                ) {
                    selectedItem = it
                }

                WithoutPaddingNavDrawerItem()

            }
        }
        //, gesturesEnabled = false
        , content = {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(text = "Screen Title")
                        },
                        navigationIcon = {
                            IconButton(
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.Red,
                                ),
                                onClick = {
                                    closeOrOpenDrawer(scope, drawerState)
                                }) {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            }
                        })
                },
                floatingActionButton = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        ExtendedFloatingActionButton(
                            text = { Text("Show drawer") },
                            icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                            onClick = {
                                closeOrOpenDrawer(scope, drawerState)
                            }
                        )
                    }
                }
            ) { contentPadding ->
                // Screen content

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "DismissibleNav")
                }
            }
        })
}

private fun closeOrOpenDrawer(scope: CoroutineScope, drawerState: DrawerState) {
    scope.launch {
        drawerState.apply {
            if (isClosed) open() else close()
        }
    }
}


@Preview
@Composable
fun DismissibleNavDrawerSamplePreview() {
    DismissibleNavDrawerSample()
}