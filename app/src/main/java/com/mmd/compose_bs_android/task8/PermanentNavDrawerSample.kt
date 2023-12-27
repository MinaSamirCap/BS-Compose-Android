package com.mmd.compose_bs_android.task8

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
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
import com.mmd.compose_bs_android.task8.components.ItemsNavDrawerBody
import com.mmd.compose_bs_android.task8.components.ShrekNavDrawerHeader
import com.mmd.compose_bs_android.task8.components.WithoutPaddingNavDrawerItem
import com.mmd.compose_bs_android.task8.models.NavigationDrawerUiModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermanentNavDrawerSample() {

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    val drawerNavItems = remember {
        NavigationDrawerUiModel.getMainNavDrawerItems()
    }

    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet {

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

                                }) {
                                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            }
                        })
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        
                    }) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
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
                    Text(text = "P e r m a n e n t N a v")
                }
            }
        })
}

@Preview(widthDp = 1024)
@Composable
fun PermanentNavDrawerSamplePreview() {
    PermanentNavDrawerSample()
}