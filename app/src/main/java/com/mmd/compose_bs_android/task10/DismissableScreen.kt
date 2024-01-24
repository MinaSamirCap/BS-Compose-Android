package com.mmd.compose_bs_android.task10

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mmd.compose_bs_android.task10.components.FullEmailItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissibleScreen(
    viewModel: DismissibleViewModel = viewModel()
) {

    val messages by viewModel.messagesState.collectAsState()

    Scaffold(
        topBar = {
            ScreenToolbar(onRefreshClick = viewModel::refresh)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(vertical = 12.dp),
        ) {
            itemsIndexed(
                items = messages,
                key = { _, item -> item.hashCode() }
            ) { _, model ->
                FullEmailItem(model, onRemove = viewModel::removeItem)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenToolbar(onRefreshClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Email App") },
        actions = {
            IconButton(onClick = onRefreshClick) {
                Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
            }
        }
    )
}

@Preview
@Composable
fun DismissibleScreenPreview() {
    DismissibleScreen()
}


/// references ...
/// https://www.geeksforgeeks.org/android-jetpack-compose-swipe-to-dismiss-with-material-3/
