package com.mmd.compose_bs_android.task5.view_model_version

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.task5.SharedButton
import com.mmd.compose_bs_android.task5.TitleList


@Composable
fun OffersList(
    list: List<OfferUiModel>,
    onItemClick: ((OfferUiModel) -> Unit)? = null
) {

    Column {
        TitleList("Filter by offering")
        LazyRow(
            contentPadding = PaddingValues(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(list.size) { index ->
                val item = list[index]
                SharedButton(
                    isSelected = item.checked,
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
                        onItemClick?.invoke(item)
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

    var checked: Boolean by mutableStateOf(isSelected)
    companion object {
        fun offers() = mutableStateListOf(
            OfferUiModel(isSelected = false, "Notification", Icons.Default.Notifications),
            OfferUiModel(isSelected = false, "Shop Cart", Icons.Default.ShoppingCart),
            OfferUiModel(isSelected = false, "Special Events", Icons.Default.DateRange)
        )
    }
}

@Preview
@Composable
fun OffersListPreview() {
    OffersList(OfferUiModel.offers())
}
