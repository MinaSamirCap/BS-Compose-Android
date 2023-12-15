package com.mmd.compose_bs_android.task5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun OffersList(
    resetFilters: Boolean = false,
    onFilterChange: ((Int) -> Unit)? = null
) {


    val offersList = remember {
        OfferUiModel.times()
    }

    if (resetFilters) {
        for (i in 0..<offersList.size) {
            offersList[i] = offersList[i].copy(isSelected = false)
        }
    }

    Column {
        TitleList("Filter by offering")
        LazyRow(
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(offersList.size) { index ->
                val item = offersList[index]
                SharedButton(
                    isSelected = item.isSelected,
                    content = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = item.name)
                            }
                        }

                    }, onClick = {
                        offersList[index] = item.copy(isSelected = !item.isSelected)
                        onFilterChange?.invoke(offersList.filter { it.isSelected }.size)
                    })
            }
        }
    }
}

data class OfferUiModel(
    val isSelected: Boolean,
    val name: String,
    val icon: ImageVector
) {
    companion object {
        fun times() = mutableStateListOf(
            OfferUiModel(isSelected = false, "Notification", Icons.Default.Notifications),
            OfferUiModel(isSelected = false, "Shop Cart", Icons.Default.ShoppingCart),
            OfferUiModel(isSelected = false, "Special Events", Icons.Default.DateRange)
        )
    }
}

@Preview
@Composable
fun OffersListPreview() {
    OffersList()
}
