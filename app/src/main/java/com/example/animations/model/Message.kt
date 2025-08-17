package com.example.animations.model

data class Message(
    val name: String,
    val originalContent: String,
    val date: String,
    val isSender: Boolean,
    val fullContentMode: Boolean = false
) {
    val truncated: Boolean get() = originalContent.length > 50
    val content: String
        get() {
            return if (truncated && !fullContentMode) {
                originalContent.take(50)
            } else {
                originalContent
            }
        }
}
