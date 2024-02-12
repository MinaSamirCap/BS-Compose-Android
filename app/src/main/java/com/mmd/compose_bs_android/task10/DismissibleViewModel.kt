package com.mmd.compose_bs_android.task10

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DismissibleViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _messagesState = MutableStateFlow(emptyList<EmailMessageUiModel>())
    val messagesState: StateFlow<List<EmailMessageUiModel>> = _messagesState.asStateFlow()

    init {
        _messagesState.update { EmailMessageUiModel.models() }
    }

    fun refresh() {
        _messagesState.update { EmailMessageUiModel.models() }
    }

    fun pullToRefresh() {
        viewModelScope.launch {
            _isLoading.update { true }
            delay(1500)
            _messagesState.update { EmailMessageUiModel.models() }
            _isLoading.update { false }
        }
    }


    fun removeItem(currentItem: EmailMessageUiModel) {
        _messagesState.update {
            val mutableList = it.toMutableList()
            mutableList.remove(currentItem)
            mutableList
        }
    }
}