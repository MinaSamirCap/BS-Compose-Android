package com.mmd.compose_bs_android.mine.popup

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun PopupMenuScreen() {

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        val dropDownItems = mutableListOf(
            DropDownItem("Add"),
            DropDownItem("Edit"),
            DropDownItem("Delete"),
        )

        items(100) { index ->
            PersonItem(
                personName = "Name: $index",
                dropDownItems = dropDownItems,
                onClick = {
                    Toast.makeText(context, it.text, Toast.LENGTH_SHORT).show()
                })
        }
    }
}


/// references ...
/// https://www.youtube.com/watch?v=QCSJfMqQY9A&ab_channel=PhilippLackner
/// https://semicolonspace.com/jetpack-compose-dropdown-menu-material3/
/// https://m3.material.io/components/menus/overview