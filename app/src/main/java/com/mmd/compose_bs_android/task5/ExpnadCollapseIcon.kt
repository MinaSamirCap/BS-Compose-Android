package com.mmd.compose_bs_android.task5

import androidx.compose.animation.Crossfade
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExpandCollapseIcon(isExpanded: Boolean, color: Color) {

    Crossfade(targetState = isExpanded, label = "expandCollapseAnim") { shouldAsExpanded ->
        // note that it's required to use the value passed by Crossfade
        // instead of your state value
        if (shouldAsExpanded) {
            Icon(
                Icons.Default.KeyboardArrowUp, contentDescription = null, tint = color
            )
        } else {
            Icon(
                Icons.Default.KeyboardArrowDown, contentDescription = null, tint = color
            )
        }
    }
}

@Preview
@Composable
fun ExpandCollapseIconPreview() {
    ExpandCollapseIcon(isExpanded = true, color = Color.Green)
}

@Preview
@Composable
fun ExpandCollapseIconPreview2() {
    ExpandCollapseIcon(isExpanded = false, color = Color.Green)
}