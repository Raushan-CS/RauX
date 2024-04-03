package com.example.raux

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.raux.components.ChatFooter
import com.example.raux.components.ChatHeader
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.raux.components.ChatList

@Composable
fun ChatBot(
    viewModel: ChatBotViewModel = viewModel()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ChatHeader()

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if(viewModel.list.isEmpty()) {
                Text(text = "How can I help you today?",
                    modifier = Modifier.background(MaterialTheme.colorScheme.background))
            }
            ChatList(list = viewModel.list)
        }

        ChatFooter {
            if (it.isNotEmpty()) {
                viewModel.sendMessage(it)
            }
        }
    }
}

@Preview
@Composable
fun ChatBotPreview() {
    ChatBot()
}