package com.mmd.compose_bs_android.task10.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.task10.EmailMessageUiModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullEmailItem(
    model: EmailMessageUiModel,
    onRemove: ((EmailMessageUiModel) -> Unit)? = null
) {
    val context = LocalContext.current
    val currentItem by rememberUpdatedState(model)
    val dismissState = rememberDismissState(
        confirmValueChange = {
            if (it == DismissValue.DismissedToStart || it == DismissValue.DismissedToEnd) {
                model.show = false
                true
            } else {
                false
            }
        },
        positionalThreshold = {
            150.dp.toPx()
        }
    )
    AnimatedVisibility(
        model.show, exit = fadeOut(spring())
    ) {
        SwipeToDismiss(
            state = dismissState,
            modifier = Modifier,
            background = {
                DismissBackground(dismissState)
            },
            dismissContent = {
                EmailMessageItem(model)
            }
        )
    }

    LaunchedEffect(model.show) {
        if (!model.show) {
            delay(800)
            onRemove?.invoke(currentItem)
            Toast.makeText(context, "Item removed", Toast.LENGTH_SHORT).show()
        }
    }
}


@Preview
@Composable
fun FullEmailItemPreview() {
    FullEmailItem(EmailMessageUiModel.sampleModel())
}