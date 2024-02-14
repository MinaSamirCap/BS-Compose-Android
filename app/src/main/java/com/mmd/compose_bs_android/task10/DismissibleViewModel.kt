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

    private val _isDismissing = MutableStateFlow(false)
    val isDismissing = _isDismissing.asStateFlow()

    private val _messagesState = MutableStateFlow(emptyList<EmailMessageUiModel>())
    val messagesState: StateFlow<List<EmailMessageUiModel>> = _messagesState.asStateFlow()

    var lastDismissedItem: EmailMessageUiModel? = null
    var lastDismissedIndex: Int? = null

    init {
        _messagesState.update { EmailMessageUiModel.models() }
    }

    fun refresh() {
        _messagesState.update {
            mutableListOf(
                EmailMessageUiModel("John Doe", "Hello"),
                EmailMessageUiModel("Alice", "Hey there! How's it going?"),
                EmailMessageUiModel("Bob", "I just discovered a cool new programming language!"),
                EmailMessageUiModel(
                    "Geek",
                    "Have you seen the latest tech news? It's fascinating!"
                ),
                EmailMessageUiModel("Mark", "Let's grab a coffee and talk about coding!"),
                EmailMessageUiModel(
                    "Cyan",
                    "I need help with a coding problem. Can you assist me?"
                ),
            )
        }
    }

    fun pullToRefresh() {
        viewModelScope.launch {
            _isLoading.update { true }
            delay(1500)
            _messagesState.update { EmailMessageUiModel.models() }
            _isLoading.update { false }
        }
    }

    fun dismissItem(currentItem: EmailMessageUiModel) {
        _isDismissing.update { true }
        lastDismissedItem = currentItem
        lastDismissedIndex = _messagesState.value.indexOf(currentItem)
        viewModelScope.launch {
            delay(2000)
            _isDismissing.update { false }
        }
    }

    fun undoDismissItem() {
        _messagesState.update {
            val mutableList = it.toMutableList()
            mutableList.add(lastDismissedIndex!!, lastDismissedItem!!)
            mutableList
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