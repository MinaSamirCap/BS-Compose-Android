package com.mmd.compose_bs_android.mine.glowing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GlowingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column {
            GlowingCard(
                modifier = Modifier.size(200.dp),
                glowingColor = Color.Blue,
                containerColor = Color.White,
                cornerRadius = 10.dp,
                xShifting = 10.dp,
                yShifting = 10.dp
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Mina Samir",
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            GlowingCard(
                modifier = Modifier.size(200.dp),
                glowingColor = Color.Red,
                containerColor = Color.Black,
                cornerRadius = Int.MAX_VALUE.dp,
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Mina Samir",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun GlowingScreenPreview() {
    GlowingScreen()
}