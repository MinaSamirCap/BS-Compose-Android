package com.mmd.compose_bs_android.task5.view_model_version

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FilterWithAnimationViewModel : ViewModel() {

    var filterCount: Int by mutableIntStateOf(0)

    var daysList: List<DayUiModel> = DayUiModel.days()
    val timesList: List<TimeUiModel> = TimeUiModel.times()
    val offersList: List<OfferUiModel> = OfferUiModel.offers()

    fun onDayClicked(model: DayUiModel) {
        model.checked = !model.checked
        updateFilterCount()
    }

    fun onTimeClicked(model: TimeUiModel) {
        model.checked = !model.checked
        updateFilterCount()
    }

    fun onOfferClicked(model: OfferUiModel) {
        model.checked = !model.checked
        updateFilterCount()
    }

    fun clearFilter() {
        filterCount = 0
        daysList.forEach { it.checked = false }
        timesList.forEach { it.checked = false }
        offersList.forEach { it.checked = false }
    }

    private fun updateFilterCount() {
        val daysCount = daysList.filter { it.checked }.size
        val timesCount = timesList.filter { it.checked }.size
        val offersCount = offersList.filter { it.checked }.size

        filterCount = daysCount + timesCount + offersCount
    }
}