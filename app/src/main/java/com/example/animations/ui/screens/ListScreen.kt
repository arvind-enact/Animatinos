package com.example.animations.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animations.data.sampleMessages
import com.example.animations.ui.components.ReceiverMessage
import com.example.animations.ui.components.SenderMessage

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    // Use a different variable name for the initial data list
    val initialMessages = remember { sampleMessages } // <-- your 50+ message list

    // Create a SnapshotStateList<Message>
    val messages = remember { mutableStateListOf(*initialMessages.toTypedArray()) }

    LazyColumn(modifier, contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp)) {
        itemsIndexed(messages, key = { _, message -> message.hashCode() }) { index, message ->
            val toggleReadMore = {
                messages[index] = messages[index].copy(
                    fullContentMode = !messages[index].fullContentMode
                )
            }

            if (message.isSender) {
                SenderMessage(
                    message = message,
                    onToggleReadMore = toggleReadMore,
                )
            } else {
                ReceiverMessage(
                    message = message,
                    onToggleReadMore = toggleReadMore
                )
            }
        }
    }
}
