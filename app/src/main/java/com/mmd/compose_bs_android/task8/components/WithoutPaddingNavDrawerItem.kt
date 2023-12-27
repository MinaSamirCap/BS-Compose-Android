package com.mmd.compose_bs_android.task8.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WithoutPaddingNavDrawerItem() {
    NavigationDrawerItem(
        shape = MaterialTheme.shapes.medium,
        label = {
            Column {
                Text(text = "Drawer Not Padding Item")
                Text(text = "App Version: 0.0.0.1")
            }
        },
        selected = true,
        onClick = {

        }
    )
}

@Preview
@Composable
fun WithoutPaddingNavDrawerItemPreview() {
    WithoutPaddingNavDrawerItem()
}