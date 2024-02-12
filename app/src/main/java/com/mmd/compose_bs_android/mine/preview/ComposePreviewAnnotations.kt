package com.mmd.compose_bs_android.mine.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.mmd.compose_bs_android.task9.TabRowSample

@PreviewScreenSizes
@PreviewFontScale
@PreviewLightDark
@PreviewDynamicColors
@Composable
fun ComposePreviewAnnotations() {
    TabRowSample()
}