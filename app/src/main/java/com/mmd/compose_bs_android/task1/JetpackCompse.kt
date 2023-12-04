package com.mmd.compose_bs_android.task1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mmd.compose_bs_android.ui.theme.ComposeBSAndroidTheme


@Composable
fun JetpackCompose(
    modifier: Modifier = Modifier,
    text: String = "JetbackCompose",
    texts: MutableList<String> = mutableListOf("J", "C")
) {

    /// extract texts from text
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val annotatedString = buildAnnotatedString {

            bigRedText("J")
            mediumBlackText("etpack")
            bigRedText("C")
            mediumBlackText("ompose")

        }

        Text(
            text = annotatedString,
            modifier = modifier,
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                fontStyle = FontStyle.Italic
            )
        )
    }
}

private fun AnnotatedString.Builder.bigRedText(text: String) {
    withStyle(
        style = SpanStyle(
            color = Color.Blue,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold
        )
    ) {
        append(text)
    }
}


private fun AnnotatedString.Builder.mediumBlackText(text: String) {
    withStyle(
        style = SpanStyle(
            color = Color.Black,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    ) {
        append(text)
    }
}

@Preview(showBackground = true)
@Composable
fun JetpackComposePreview() {
    ComposeBSAndroidTheme {
        JetpackCompose()
    }
}