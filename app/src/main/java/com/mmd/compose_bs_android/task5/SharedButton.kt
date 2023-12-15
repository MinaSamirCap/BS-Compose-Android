package com.mmd.compose_bs_android.task5

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.R


@Composable
fun SharedButton(
    isSelected: Boolean,
    contentPadding: PaddingValues = PaddingValues(vertical = 20.dp, horizontal = 10.dp),
    content: @Composable () -> Unit,
    onClick: (() -> Unit)? = null,
) {
    val containerColor = if (isSelected) colorResource(id = R.color.science_blue) else Color.White
    val textColor = if (isSelected) Color.White else Color.DarkGray
    Button(
        contentPadding = contentPadding,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 1.dp, color = if (isSelected) containerColor else textColor),
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor,
            containerColor = containerColor
        ),
        onClick = {
            onClick?.invoke()
        }) {
        content()

    }
}

@Preview
@Composable
fun SharedButtonPreview() {
    SharedButton(isSelected = true, content = { Text(text = "Test") })
}

@Preview
@Composable
fun SharedButtonPreview2() {
    SharedButton(isSelected = false, content = { Text(text = "Test") })
}