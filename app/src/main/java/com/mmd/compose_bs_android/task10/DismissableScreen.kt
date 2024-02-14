package com.mmd.compose_bs_android.task10

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mmd.compose_bs_android.task10.components.EmailMessageItem
import com.mmd.compose_bs_android.task10.components.SwipeToDeleteContainer

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DismissibleScreen(
    viewModel: DismissibleViewModel = viewModel()
) {

    val messages by viewModel.messagesState.collectAsState()
    val isRefreshing by viewModel.isLoading.collectAsState()
    val isDismissing by viewModel.isDismissing.collectAsState()
    val pullRefreshState = rememberPullRefreshState(isRefreshing, { viewModel.pullToRefresh() })

    Scaffold(
        topBar = {
            ScreenToolbar(onRefreshClick = viewModel::refresh)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .pullRefresh(pullRefreshState)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 12.dp),
            ) {
                itemsIndexed(
                    items = messages,
                    key = { index, item -> item.hashCode() }
                ) { index, model ->
                    SwipeToDeleteContainer(
                        item = model,
                        onDelete = {
                            viewModel.dismissItem(it)
                            viewModel.removeItem(it)
                        }, content = {
                            EmailMessageItem(model = model)
                        })
                }
            }

            if (isDismissing) {
                ElevatedButton(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 80.dp),
                    onClick = {
                        viewModel.undoDismissItem()
                    }) {
                    Text(text = "UNDO")
                }
            }

            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
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
/// https://www.youtube.com/watch?v=IlI6GgC_j78&ab_channel=PhilippLackner
