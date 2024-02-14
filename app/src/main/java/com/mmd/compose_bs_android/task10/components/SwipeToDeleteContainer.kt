package com.mmd.compose_bs_android.task10.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SwipeToDeleteContainer(
    item: T,
    onDelete: ((T) -> Unit)? = null,
    animationDuration: Int = 500,
    content: (@Composable (T) -> Unit)? = null
) {

    var isRemoved by remember {
        mutableStateOf(false)
    }

    val dismissState = rememberDismissState(
        initialValue = DismissValue.Default,
        confirmValueChange = {
            if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
                isRemoved = true
                true
            } else {
                false
            }
        },
        positionalThreshold = {
            150.dp.toPx()
        }
    )

    LaunchedEffect(key1 = isRemoved) {
        if (isRemoved) {
            delay(animationDuration.toLong())
            dismissState.reset()
            onDelete?.invoke(item)
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismiss(
            state = dismissState,
            modifier = Modifier,
            background = {
                DismissBackground(dismissState)
            },
            dismissContent = {
                content?.invoke(item)
            },
            directions = setOf(
                DismissDirection.EndToStart,
                DismissDirection.StartToEnd
            )
        )
    }

}

@Preview
@Composable
fun SwipeToDeleteContainerPreview() {
    SwipeToDeleteContainer<Any>(true)
}