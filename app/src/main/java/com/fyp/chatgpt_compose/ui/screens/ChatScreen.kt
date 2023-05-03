package com.fyp.chatgpt_compose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.fyp.chatgpt_compose.models.Chat
import com.fyp.chatgpt_compose.ui.theme.Lato

@Composable
fun ChatScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<ChatScreenViewModel>()
    var userInput by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(listOf<Chat>()) }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            reverseLayout = true
        ) {
            items(messages.reversed()) { message ->
                MessageBubble(message)
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = userInput,
                onValueChange = { userInput = it },
                modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.body1.copy(
                    fontSize = 16.sp,
                    fontFamily = Lato,
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Type a message...",
                        color = MaterialTheme.colors.primary,
                        fontFamily = Lato,
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        if (userInput.isNotBlank()) {
                            val input = userInput
                            userInput = ""
                            messages += Chat(message = input, isUser = true)
                            viewModel.getResponse(input) {
                                messages += Chat(message = it, isUser = false)
                            }
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Send,
                            tint = MaterialTheme.colors.primary,
                            contentDescription = "Send"
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun MessageBubble(message: Chat) {
    val backgroundColor = if (message.isUser) {
        MaterialTheme.colors.primary
    } else {
        MaterialTheme.colors.onSecondary
    }

    val contentColor = if (message.isUser) {
        MaterialTheme.colors.onPrimary
    } else {
        MaterialTheme.colors.onSurface
    }

    val alignment = if (message.isUser) {
        Alignment.BottomEnd
    } else {
        Alignment.BottomStart
    }

    val shape = if (message.isUser) {
        RoundedCornerShape(16.dp, 0.dp, 16.dp, 16.dp)
    } else {
        RoundedCornerShape(0.dp, 16.dp, 16.dp, 16.dp)
    }

    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        contentAlignment = alignment
    ) {
        Card(
            modifier = Modifier.padding(8.dp),
            shape = shape,
            backgroundColor = backgroundColor,
            contentColor = contentColor,

            ) {
            Text(
                text = message.message,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 16.sp,
                    fontFamily = Lato,
                    letterSpacing = 1.sp,
                    lineHeight = 24.sp


                )
            )
        }
    }
}
