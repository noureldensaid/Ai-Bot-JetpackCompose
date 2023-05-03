package com.fyp.chatgpt_compose.models

data class Chat(
    // message content
    var message: String,
    // detect sender
    val isUser: Boolean
)
