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

@Composable
fun SenderMessage(
    message: Message,
    onToggleReadMore: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = Color(0xFFDCF8C6),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
                .widthIn(max = 250.dp)
        ) {
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
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
fun ReceiverMessage(
    message: Message,
    onToggleReadMore: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
                .widthIn(max = 250.dp)
        ) {
            Text(
                text = message.name,
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFF075E54)
            )
            Spacer(modifier = Modifier.height(2.dp))

            val displayText = buildAnnotatedString {
                append(
                    if (message.truncated && !message.fullContentMode) {
                        message.content.take(100) + "... "
                    } else {
                        message.content
                    }
                )
                if (message.truncated && !message.fullContentMode) {
                    pushLink(LinkAnnotation.Clickable(
                        tag = "readMoreLink",
                        linkInteractionListener = {
                            onToggleReadMore()
                        }
                    ))
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Read more")
                    }
                    pop()
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
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}
