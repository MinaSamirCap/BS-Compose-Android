package com.mmd.compose_bs_android.task9.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ImageSearch
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldSheetsTab() {

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            skipHiddenState = false
        )
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetDragHandle = {
            Text(text = "Drag from here ...", color = Color.Blue)
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Center Title") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.TwoTone.ImageSearch, contentDescription = null)
                    }
                })
        },
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Text(text = "Scaffold Bottom Sheet ... ")
            }
        }) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = {
                coroutineScope.launch {
                    scaffoldState.bottomSheetState.expand()
                }
            }) {
                Text(text = "expand scaffold sheet")
            }

            Button(onClick = {
                coroutineScope.launch {
                    scaffoldState.bottomSheetState.show()
                    // to totally hide the sheet ...
                    //scaffoldState.bottomSheetState.hide()
                }
            }) {
                Text(text = "hide bottom sheet")
            }

        }
    }
}

@Preview
@Composable
fun ScaffoldSheetsTabPreview() {
    ScaffoldSheetsTab()
}


/// reference ...
/// https://www.youtube.com/watch?v=VxgWUdOKgtI&list=PLQkwcJG4YTCT1LkjokmzZUFFyFVVWPuKk&ab_channel=PhilippLackner

