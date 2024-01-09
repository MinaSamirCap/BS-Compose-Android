package com.mmd.compose_bs_android.task9.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ProgressBarsTab() {

    val scope = rememberCoroutineScope()

    var percent by rememberSaveable {
        mutableFloatStateOf(0.0f)
    }

    LaunchedEffect(key1 = percent)
    {
        scope.launch {
            delay(500)
            percent += 0.1f
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        CircularProgressIndicator()


        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            progress = percent,
            color = Color.Red,
            trackColor = Color.Gray,
        )

        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            progress = percent,
            color = Color.Blue
        )

    }

}

@Preview
@Composable
fun ProgressBarsTabPreview() {
    ProgressBarsTab()
}

