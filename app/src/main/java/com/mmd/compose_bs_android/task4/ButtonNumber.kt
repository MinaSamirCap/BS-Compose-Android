package com.mmd.compose_bs_android.task4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ButtonNumber() {

    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column {
        SingleLayout(
            modifier = Modifier.weight(1f),
            color = Color.Cyan
        ) {
            Text(text = counter.toString(), fontSize = 40.sp)
        }
        SingleLayout(
            modifier = Modifier.weight(1f), color = Color.DarkGray
        ) {

            ElevatedButton(onClick = {
                counter++
            }) {
                Text(text = "Increment 1", color = Color.DarkGray)
            }
        }
    }
}

@Composable
private fun SingleLayout(
    modifier: Modifier = Modifier,
    color: Color,
    centerCompose: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        centerCompose()
    }
}


@Preview
@Composable
fun ButtonNumberPreview() {
    ButtonNumber()
}