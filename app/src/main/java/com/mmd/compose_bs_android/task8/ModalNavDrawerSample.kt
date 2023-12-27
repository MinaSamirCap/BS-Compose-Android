package com.mmd.compose_bs_android.task8

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
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
fun ModalNavDrawerSample() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    val drawerNavItems = remember {
        NavigationDrawerUiModel.getMainNavDrawerItems()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.7f),
            ) {

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
        },
        scrimColor = Color.Green.copy(alpha = 0.2f)
        //gesturesEnabled = false
        , content = {
            Scaffold(
                snackbarHost = {
                    SnackbarHost(
                        hostState = snackbarHostState,
                        /*snackbar = {
                            Snackbar(
                                modifier = Modifier.padding(20.dp),
                                actionOnNewLine = true,
                                action = { Text("Hi") },
                                dismissAction = {
                                    Icon(
                                        imageVector = Icons.Default.Share,
                                        contentDescription = null
                                    )
                                }
                            ) {
                                Text(text = "fsfs")
                            }
                        }*/
                    )
                },
                floatingActionButton = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        ExtendedFloatingActionButton(
                            text = { Text("Show snackbar") },
                            icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                            onClick = {
                                showSnackbar("This is snackbar", scope, snackbarHostState)
                            }
                        )

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
                    Text(text = "Modal Nav Drawer")
                }
            }
        })
}

private fun showSnackbar(message: String, scope: CoroutineScope, snackbarHostState: SnackbarHostState) {
    scope.launch {
        snackbarHostState.currentSnackbarData?.dismiss()
        val result = snackbarHostState.showSnackbar(
            message = message,
            actionLabel = "Action",
            withDismissAction = true
        )

        when (result) {
            SnackbarResult.Dismissed -> {
                //showSnackbar("You Dismissed me .. !", scope, snackbarHostState)
            }

            SnackbarResult.ActionPerformed -> {
                //showSnackbar("You pressed action ;)", scope, snackbarHostState)
            }
        }
    }
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
fun ModalNavDrawerSamplePreview() {
    ModalNavDrawerSample()
}


/// references ...
/// snackbar: https://www.youtube.com/watch?v=skfGvJ9PuQ0&ab_channel=MohammadArif
/// custom snackbar: https://www.youtube.com/watch?v=WLQzjtIUVmY&ab_channel=Codingwithcat