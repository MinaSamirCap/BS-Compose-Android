package com.mmd.compose_bs_android.task8.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.R

@Composable
fun ShrekNavDrawerHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxHeight(0.5f),
                painter = painterResource(id = R.drawable.img_profile),
                contentDescription = null
            )

            Text(text = "Mr Shrek")
        }

    }
}

@Preview
@Composable
fun ShrekNavDrawerHeaderPreview() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ShrekNavDrawerHeader()
    }
}