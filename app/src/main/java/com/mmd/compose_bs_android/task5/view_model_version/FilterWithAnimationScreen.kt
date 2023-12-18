package com.mmd.compose_bs_android.task5.view_model_version

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mmd.compose_bs_android.R
import com.mmd.compose_bs_android.task5.HeaderSection


@Composable
fun FilterWithAnimationScreen(
    viewModel: FilterWithAnimationViewModel = viewModel()
) {


    val scienceBlue = colorResource(id = R.color.science_blue)

    var isExpanded by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        HeaderSection(
            isExpanded,
            scienceBlue,
            viewModel.filterCount,
            expandCollapseCallback = {
                isExpanded = it
            }, clearFilterCallback = {

                viewModel.clearFilter()
            })

        AnimatedVisibility(isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                DaysList(
                    viewModel.daysList,
                    onItemClick = {
                        viewModel.onDayClicked(it)
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TimesList(
                    viewModel.timesList,
                    onItemClick = {
                        viewModel.onTimeClicked(it)
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                OffersList(
                    viewModel.offersList,
                    onItemClick = {
                        viewModel.onOfferClicked(it)
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    }

}


@Preview
@Composable
fun FilterWithAnimationScreenPreview() {
    FilterWithAnimationScreen()
}