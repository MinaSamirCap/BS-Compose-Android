package com.mmd.compose_bs_android.task5

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TitleList(text: String) {
    Text(
        modifier = Modifier.padding(start = 30.dp, bottom = 20.dp),
        text = text,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun TitleListPreview() {
    TitleList(text = "Mina Samir")
}