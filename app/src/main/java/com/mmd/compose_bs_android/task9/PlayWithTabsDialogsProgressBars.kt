package com.mmd.compose_bs_android.task9

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PlayWithTabsDialogsProgressBars() {


    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "tabsAndSheets") {
        composable("tabsAndSheets") {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Button(onClick = {
                    navController.navigate(tabRowSample)
                }) {
                    Text(text = "Tab Row")
                }

                Button(onClick = {
                    navController.navigate(scrollableTabRowSample)
                }) {
                    Text(text = "Scrollable Tab Row")
                }
            }
        }

        composable(tabRowSample) {
            TabRowSample()
        }

        composable(scrollableTabRowSample) {
            ScrollableTabRowSample()
        }

    }
}

@Preview
@Composable
fun PlayWithTabsDialogsProgressBarsPreview() {
    PlayWithTabsDialogsProgressBars()
}


private const val tabRowSample = "tabRowSample"
private const val scrollableTabRowSample = "scrollableTabRowSample"


/// references ...
// https://www.youtube.com/watch?v=9r4st6dmyNE&ab_channel=PhilippLackner