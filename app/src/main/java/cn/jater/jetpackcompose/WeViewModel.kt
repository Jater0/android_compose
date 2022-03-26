package cn.jater.jetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cn.jater.jetpackcompose.data.Chat
import cn.jater.jetpackcompose.data.Message
import cn.jater.jetpackcompose.data.User
import cn.jater.jetpackcompose.ui.theme.WeComposeTheme

class WeViewModel: ViewModel() {
    var chats by mutableStateOf(
        listOf( // List<Chat>
            Chat(
                friend = User("unknown01", "陌生人01", R.drawable.avatar_gaolaoshi),
                mutableStateListOf(
                    Message(User("unknown01", "陌生人01", R.drawable.avatar_gaolaoshi), "1", "14:20"),
                    Message(User.me, "2", "14:20"),
                    Message(User("unknown01", "陌生人01", R.drawable.avatar_gaolaoshi), "3", "14:20"),
                    Message(User.me, "4", "14:20"),
                    Message(User("unknown01", "陌生人01", R.drawable.avatar_gaolaoshi), "5", "14:20"),
                    Message(User.me, "6", "14:20"),
                    Message(User("unknown01", "陌生人01", R.drawable.avatar_gaolaoshi), "7", "14:20"),
                    Message(User.me, "8", "14:20"),
                )
            ),
            Chat(
                friend = User("unknown02", "陌生人02", R.drawable.avatar_diuwuxian),
                mutableStateListOf(
                    Message(User("unknown02", "陌生人02", R.drawable.avatar_diuwuxian), "哈哈哈", "13:48"),
                    Message(User.me, "哈哈昂", "13:48"),
                    Message(User("unknown02", "陌生人02", R.drawable.avatar_diuwuxian), "你笑个屁呀", "13:48").apply { read = false },
                )
            ),
        )
    )
    var theme by mutableStateOf(WeComposeTheme.Theme.Light)
    var currentChat: Chat? by mutableStateOf(null)
    var chatting: Boolean by mutableStateOf(false)
    val contacts by mutableStateOf(
        listOf(
            User("unknown01", "陌生人01", R.drawable.avatar_gaolaoshi),
            User("unknown02", "陌生人02", R.drawable.avatar_diuwuxian)
        )
    )

    fun startChat(chat: Chat) {
        chatting = true
        currentChat = chat
    }

    fun finishChat(): Boolean {
        if (chatting) {
            chatting = false
            return true
        }
        return false
    }

    fun boom(chat: Chat) {
        chat.messages.add(Message(User.me, "\uD83D\uDCA3", "15:10").apply { read = true })
    }
}