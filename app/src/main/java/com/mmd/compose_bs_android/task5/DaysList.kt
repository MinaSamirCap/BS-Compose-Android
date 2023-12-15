package com.mmd.compose_bs_android.task5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DaysList(
    resetFilters: Boolean = false,
    onFilterChange: ((Int) -> Unit)? = null
) {

    val daysList = remember {
        DayUiModel.days()
    }

    if (resetFilters) {
        for (i in 0..<daysList.size) {
            daysList[i] = daysList[i].copy(isSelected = false)
        }
    }

    Column {
        TitleList("Filter by day")
        LazyRow(
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(daysList.size) { index ->
                val item = daysList[index]
                SharedButton(
                    isSelected = item.isSelected,
                    content = {
                        Text(text = item.name)
                    }, onClick = {
                        daysList[index] = item.copy(isSelected = !item.isSelected)
                        onFilterChange?.invoke(daysList.filter { it.isSelected }.size)
                    })
            }
        }
    }
}

data class DayUiModel(
    val isSelected: Boolean,
    val name: String
) {
    companion object {
        fun days() = mutableStateListOf(
            DayUiModel(isSelected = false, "Sun"),
            DayUiModel(isSelected = false, "Mon"),
            DayUiModel(isSelected = false, "Tue"),
            DayUiModel(isSelected = false, "Wed"),
            DayUiModel(isSelected = false, "Thu"),
            DayUiModel(isSelected = false, "Fri"),
            DayUiModel(isSelected = false, "Sat")
        )
    }
}

@Preview
@Composable
fun DaysListPreview() {
    DaysList()
}