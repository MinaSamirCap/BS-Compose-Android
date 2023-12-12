package com.mmd.compose_bs_android.task5

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HeaderSection(
    isExpanded: Boolean,
    color: Color,
    filterCount: Int,
    expandCollapseCallback: ((Boolean) -> Unit)? = null,
    clearFilterCallback: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.clickable {
            expandCollapseCallback?.invoke(!isExpanded)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(vertical = 20.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Filters", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.width(10.dp))
                ExpandCollapseIcon(isExpanded, color)
            }
            Text(
                modifier = Modifier
                    .clickable {
                        clearFilterCallback?.invoke()
                    }
                    .padding(5.dp),
                text = "Clear Filters ($filterCount)",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = color
            )
        }
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .height(1.dp)
                .background(Color.DarkGray)
        )

    }
}

@Preview
@Composable
fun HeaderSectionPreview() {
    HeaderSection(isExpanded = true, color = Color.Cyan, 8)
}
