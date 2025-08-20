package com.example.animations.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.animations.model.Message

/**
 * A common UI component for displaying a message bubble.
 * This Composable handles the layout and display logic for both sender and receiver messages.
 *
 * @param message The message data to display.
 * @param onToggleReadMore Callback invoked when the "Read more" link is clicked.
 * @param horizontalArrangement The horizontal arrangement for the message row.
 * @param bubbleColor The background color of the message bubble.
 * @param name Optional: The name to display above the message content (e.g., for receiver).
 * @param nameColor Optional: The color for the name text, if a name is provided.
 */
@Composable
private fun CommonMessageUi(
    message: Message,
    onToggleReadMore: () -> Unit,
    horizontalArrangement: Arrangement.Horizontal,
    bubbleColor: Color,
    name: String? = null,
    nameColor: Color = Color.Unspecified
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = horizontalArrangement
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = bubbleColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
                .widthIn(max = 250.dp)
        ) {
            // Display name if provided (e.g., for ReceiverMessage)
            name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.labelMedium,
                    color = nameColor
                )
                Spacer(modifier = Modifier.height(2.dp))
            }

            val displayText = buildAnnotatedString {
                append(
                    if (message.truncated && !message.fullContentMode) {
                        message.content.take(100) + "... "
                    } else {
                        message.content
                    }
                )
                if (message.truncated && !message.fullContentMode) {
                    pushLink(
                        LinkAnnotation.Clickable(
                        tag = "readMoreLink",
                        linkInteractionListener = {
                            onToggleReadMore()
                        }
                    ))
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Read more")
                    }
                    pop() // Pop the link annotation
                }
            }

            Text(
                text = displayText,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                modifier = Modifier.animateContentSize()
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.date,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.End) // Consistent for both sender and receiver
            )
        }
    }
}

/**
 * Displays a message bubble for the sender.
 *
 * @param message The message data to display.
 * @param onToggleReadMore Callback invoked when the "Read more" link is clicked.
 */
@Composable
fun SenderMessage(
    message: Message,
    onToggleReadMore: () -> Unit,
) {
    CommonMessageUi(
        message = message,
        onToggleReadMore = onToggleReadMore,
        horizontalArrangement = Arrangement.End,
        bubbleColor = Color(0xFFDCF8C6)
    )
}

/**
 * Displays a message bubble for the receiver.
 *
 * @param message The message data to display.
 * @param onToggleReadMore Callback invoked when the "Read more" link is clicked.
 */
@Composable
fun ReceiverMessage(
    message: Message,
    onToggleReadMore: () -> Unit
) {
    CommonMessageUi(
        message = message,
        onToggleReadMore = onToggleReadMore,
        horizontalArrangement = Arrangement.Start,
        bubbleColor = Color.White,
        name = message.name,
        nameColor = Color(0xFF075E54)
    )
}
