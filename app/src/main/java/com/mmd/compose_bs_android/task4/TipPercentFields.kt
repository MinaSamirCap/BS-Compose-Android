package com.mmd.compose_bs_android.task4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TipPercentFields() {

    var value by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var percent by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Numeric Value")
            },
            placeholder = {
                Text(text = "Enter any numeric value to start the calculation")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            value = value,
            onValueChange = {
                value = it
            }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Percent Value")
            },
            placeholder = {
                Text(text = "Enter any percent, it is 15% by default")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            value = percent,
            onValueChange = {
                percent = it
            }
        )


        val annotatedString = buildAnnotatedString {

            redItalicText("That was easy")
            normalText("\n\n")
            normalText("\uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02")
            normalText("\n\n")
            blackUnderlineText("Your value is")
            normalText("\n\n")
            normalText("\n\n")
            normalText("\n\n")
            valueText(calculateValue(value.text, percent))

        }

        Text(
            text = annotatedString,
            textAlign = TextAlign.Center,
        )

    }

}

fun calculateValue(value: String, percent: String): String {
    val percentValue = if (percent.isEmpty()) {
        15f
    } else {
        percent.toFloat()
    }

    val valueValue = if (value.isEmpty()) {
        0f
    } else {
        value.toFloat()
    }

    return (valueValue * percentValue / 100).toString()
}


private fun AnnotatedString.Builder.redItalicText(text: String) {
    withStyle(
        style = SpanStyle(
            color = Color.Red,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
    ) {
        append(text)
    }
}

private fun AnnotatedString.Builder.blackUnderlineText(text: String) {
    withStyle(
        style = SpanStyle(
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline
                )
            )
        )
    ) {
        append(text)
    }
}

private fun AnnotatedString.Builder.normalText(text: String) {
    withStyle(
        style = SpanStyle(
            fontStyle = FontStyle.Normal,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.None
                )
            )
        )
    ) {
        append(text)
    }
}

private fun AnnotatedString.Builder.valueText(text: String) {
    withStyle(
        style = SpanStyle(
            color = Color.Green,
            fontSize = 88.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
    ) {
        append(text)
    }
}


@Preview
@Composable
fun TipPercentFieldsPreview() {
    TipPercentFields()
}