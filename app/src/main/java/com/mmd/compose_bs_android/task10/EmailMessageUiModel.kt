package com.mmd.compose_bs_android.task10

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class EmailMessageUiModel(
    val sender: String,
    val message: String
) {

    var isDismissed: Boolean by mutableStateOf(false)

    companion object {
        fun sampleModel() =
            EmailMessageUiModel("Mina Samir", "Hello, it is Blackstone Mobile Core Team ...")

        fun models() = mutableListOf(
            EmailMessageUiModel("John Doe", "Hello"),
            EmailMessageUiModel("Alice", "Hey there! How's it going?"),
            EmailMessageUiModel("Bob", "I just discovered a cool new programming language!"),
            EmailMessageUiModel("Geek", "Have you seen the latest tech news? It's fascinating!"),
            EmailMessageUiModel("Mark", "Let's grab a coffee and talk about coding!"),
            EmailMessageUiModel("Cyan", "I need help with a coding problem. Can you assist me?"),
        )
    }
}
