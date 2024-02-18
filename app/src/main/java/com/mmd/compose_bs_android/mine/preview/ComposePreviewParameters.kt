package com.mmd.compose_bs_android.mine.preview

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.ui.theme.ComposeBSAndroidTheme


@Composable
fun ComposePreviewParameters(isOutline: Boolean = false) {

    val isPreviewMode = LocalInspectionMode.current

    if (isOutline) {
        OutlinedButton(
            colors = ButtonDefaults.outlinedButtonColors(

            ),
            border = BorderStroke(
                width = if (isPreviewMode) 5.dp else 1.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            onClick = {

            }) {
            Text(text = "Hello world!")
        }
    } else {
        Button(onClick = {

        }) {
            Text(text = "Hello world!")
        }
    }
}

class OutlineParameterProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean>
        get() = sequenceOf(false, true)

}

@Preview
@PreviewLightDark
@PreviewDynamicColors
@Composable
fun ComposePreviewParametersPreview(
    @PreviewParameter(OutlineParameterProvider::class) isOutline: Boolean
) {
    ComposeBSAndroidTheme {
        ComposePreviewParameters(isOutline = isOutline)
    }
}

/// references ...
/// https://www.youtube.com/watch?v=nCd02GTBbIM