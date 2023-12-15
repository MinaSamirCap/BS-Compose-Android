package com.mmd.compose_bs_android.task5

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.R

@Composable
fun FilterWithAnimation() {

    val scienceBlue = colorResource(id = R.color.science_blue)

    var isExpanded by remember {
        mutableStateOf(true)
    }

    var filterCount by remember {
        mutableIntStateOf(0)
    }

    var filterDays by remember {
        mutableIntStateOf(0)
    }

    var filterTimes by remember {
        mutableIntStateOf(0)
    }

    var filterOffers by remember {
        mutableIntStateOf(0)
    }

    var resetFilter by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HeaderSection(
            isExpanded,
            scienceBlue,
            filterCount,
            expandCollapseCallback = {
                isExpanded = it
            }, clearFilterCallback = {
                filterCount = 0
                filterDays = 0
                filterTimes = 0
                filterOffers = 0
                resetFilter = true
            })

        AnimatedVisibility(isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                DaysList(
                    resetFilters = resetFilter,
                    onFilterChange = {
                        resetFilter = false
                        filterCount = filterCount - filterDays + it
                        filterDays = it
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TimesList(
                    resetFilters = resetFilter,
                    onFilterChange = {
                        resetFilter = false
                        filterCount = filterCount - filterTimes + it
                        filterTimes = it
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                OffersList(
                    resetFilters = resetFilter,
                    onFilterChange = {
                        resetFilter = false
                        filterCount = filterCount - filterOffers + it
                        filterOffers = it
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    }

}

@Preview
@Composable
fun FilterWithAnimationPreview() {
    FilterWithAnimation()
}