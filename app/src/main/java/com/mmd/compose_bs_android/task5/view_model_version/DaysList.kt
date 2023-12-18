package com.mmd.compose_bs_android.task5.view_model_version

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.task5.SharedButton
import com.mmd.compose_bs_android.task5.TitleList


@Composable
fun DaysList(
    list: List<DayUiModel>,
    onItemClick: ((DayUiModel) -> Unit)? = null
) {

    Column {
        TitleList("Filter by day")
        LazyRow(
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(list.size) { index ->
                val item = list[index]
                SharedButton(
                    isSelected = item.checked,
                    content = {
                        Text(text = item.name)
                    }, onClick = {
                        onItemClick?.invoke(item)
                    })
            }
        }
    }
}

data class DayUiModel(
    val isSelected: Boolean,
    val name: String
) {
    var checked: Boolean by mutableStateOf(isSelected)

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
    DaysList(list = DayUiModel.days())
}