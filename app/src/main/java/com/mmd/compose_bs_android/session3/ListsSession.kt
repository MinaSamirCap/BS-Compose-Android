package com.mmd.compose_bs_android.session3

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ListsSession() {
    LazyColumn {
        item {
            Text("This is header", fontSize = 40.sp)
        }

        items(30) { index ->
            Text(text = "Item $index", fontSize = 25.sp)
        }
    }
}

@Preview
@Composable
fun ListsSessionPreview() {
    ListsSession()
}