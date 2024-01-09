package com.mmd.compose_bs_android.task9.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SheetsTab() {
    var showNormalSheet by rememberSaveable {
        mutableStateOf(false)
    }

    var showCustomSheet by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            showNormalSheet = true
        }) {
            Text(text = "Modal bottom sheet")
        }

        Button(onClick = {
            showCustomSheet = true
        }) {
            Text(text = "Custom bottom sheet")
        }

    }


    if (showNormalSheet) {
        NormalSheet {
            showNormalSheet = false
        }
    }

    if (showCustomSheet) {
        CustomSheet {
            showCustomSheet = false
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalSheet(
    onDismissed: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {
            onDismissed.invoke()
        }) {

        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .height(200.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Text(text = "Modal Button Sheet")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSheet(
    onDismissed: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        scrimColor = Color.Red.copy(alpha = 0.2f),
        shape = RoundedCornerShape(10.dp),
        sheetState = sheetState,
        onDismissRequest = {
            onDismissed.invoke()
        },
        dragHandle = {

        }) {

        Box(
            modifier = Modifier
                .navigationBarsPadding()
                .background(Color.Yellow)
                .height(200.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Text(text = "Modal Button Sheet")
        }
    }
}


@Preview
@Composable
fun SheetsTabPreview() {
    SheetsTab()
}

