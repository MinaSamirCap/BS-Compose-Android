package com.mmd.compose_bs_android.task10

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DismissibleViewModel : ViewModel() {

    private val _messagesState = MutableStateFlow(emptyList<EmailMessageUiModel>())
    val messagesState: StateFlow<List<EmailMessageUiModel>> = _messagesState.asStateFlow()

    init {
        _messagesState.update { EmailMessageUiModel.models() }
    }

    fun refresh() {
        _messagesState.update { EmailMessageUiModel.models() }
    }


    fun removeItem(currentItem: EmailMessageUiModel) {
        _messagesState.update {
            val mutableList = it.toMutableList()
            mutableList.remove(currentItem)
            mutableList
        }
    }
}