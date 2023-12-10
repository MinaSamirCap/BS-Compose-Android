package com.mmd.compose_bs_android.task3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayWithLists() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn {
            items(20) {
                TimeCardList()
            }
        }
    }
}

@Composable
fun TimeCardList(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                lineHeight = 16.sp,
                fontSize = 17.sp,
                text = "Text text text text te xt text t e x t t e xt textt e x ttext  t e x t ",
                fontWeight = FontWeight.Bold,
                color = Color.Cyan
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                modifier = Modifier.fillMaxHeight(),
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                text = "7.33 mi",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(5) {
                TimeCard()
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {

            Divider(
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun TimeCard(
    modifier: Modifier = Modifier
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Card(
        modifier = modifier
            .width(screenWidth * 65 / 100)
            .widthIn(max = 400.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .background(Color.DarkGray.copy(0.88f))
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "8:00 AM - 9:00 AM",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Led by Coach Greg M.",
                color = Color.White,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan,
                    contentColor = Color.Black,
                ),
                onClick = {

                }) {
                Text(text = "RSVP")
            }
        }
    }

}

@Preview
@Composable
fun PlayWithListsPreview() {
    PlayWithLists()
}