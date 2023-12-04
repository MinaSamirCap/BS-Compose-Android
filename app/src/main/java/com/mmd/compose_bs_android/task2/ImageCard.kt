package com.mmd.compose_bs_android.task2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.R
import com.mmd.compose_bs_android.ui.theme.ComposeBSAndroidTheme

@Composable
fun ImageCard(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.brand),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black,
                            Color.Black
                        ),
                        tileMode = TileMode.Clamp,
                        startY = 0f, // Starting Y position of the gradient
                        endY = 400f // Ending Y position of the gradient
                    )
                )
                .padding(5.dp),
            text = "This is a text", color = Color.White
        )

        Icon(
            Icons.Default.Favorite,
            modifier = Modifier
                .size(44.dp)
                .border(width = 2.dp, color = Color.Cyan, shape = MaterialTheme.shapes.medium)
                .padding(4.dp),
            tint = Color.Cyan, contentDescription = null
        )
    }

}

@Preview
@Composable
fun ImageCardPreview() {
    ComposeBSAndroidTheme {
        ImageCard()
    }
}