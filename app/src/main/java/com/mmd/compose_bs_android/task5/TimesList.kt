package com.mmd.compose_bs_android.task5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimesList(
    resetFilters: Boolean = false,
    onFilterChange: ((Int) -> Unit)? = null
) {

    val timesList = remember {
        TimeUiModel.times()
    }

    if (resetFilters) {
        for (i in 0..<timesList.size) {
            timesList[i] = timesList[i].copy(isSelected = false)
        }
    }

    Column {
        TitleList("Filter by time")
        LazyRow(
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(timesList.size) { index ->
                val item = timesList[index]
                SharedButton(
                    isSelected = item.isSelected,
                    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 15.dp),
                    content = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text(text = item.time)
                        }

                    }, onClick = {
                        timesList[index] = item.copy(isSelected = !item.isSelected)
                        onFilterChange?.invoke(timesList.filter { it.isSelected }.size)
                    })
            }
        }
    }
}


data class TimeUiModel(
    val isSelected: Boolean,
    val name: String,
    val time: String
) {
    companion object {
        fun times() = mutableStateListOf(
            TimeUiModel(isSelected = false, "Morning", "8AM - 12PM"),
            TimeUiModel(isSelected = false, "Afternoon", "12PM - 5PM"),
            TimeUiModel(isSelected = false, "Evening", "5PM - 9PM")
        )
    }
}

@Preview
@Composable
fun TimesListPreview() {
    TimesList()
}