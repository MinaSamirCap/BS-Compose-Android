package com.mmd.compose_bs_android.mine.glowing

import android.graphics.Paint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GlowingCard(
    modifier: Modifier = Modifier,
    glowingColor: Color,
    containerColor: Color,
    cornerRadius: Dp = 0.dp,
    glowingRadius: Dp = 20.dp,
    xShifting: Dp = 0.dp,
    yShifting: Dp = 0.dp,
    content: @Composable BoxScope.() -> Unit
) {

    Box(
        modifier = modifier.drawBehind {
            val size = this.size
            // the below function will not five us full capabilities to draw the glowing
            //drawRect()

            // we will have all functions in native canvas .. (normal view system)
            drawContext.canvas.nativeCanvas.apply {
                drawRoundRect(
                    0f,
                    0f,
                    size.width,
                    size.height,
                    cornerRadius.toPx(),
                    cornerRadius.toPx(),
                    Paint().apply {
                        color = containerColor.toArgb()
                        setShadowLayer(
                            glowingRadius.toPx(),
                            xShifting.toPx(),
                            yShifting.toPx(),
                            glowingColor.copy(alpha = 0.5f).toArgb()
                        )
                    }
                )
            }
        }
    ) {
        content()
    }
}


@Preview
@Composable
fun GlowingCardPreview() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        GlowingCard(
            glowingColor = Color.Yellow,
            containerColor = Color.White,
            cornerRadius = 5.dp,
            xShifting = 5.dp,
            yShifting = 5.dp,
            content = {
                Text(text = "Testing ...")
            }
        )
    }
}