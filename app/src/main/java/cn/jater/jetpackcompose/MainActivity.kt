package cn.jater.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import cn.jater.jetpackcompose.ui.ChatPage
import cn.jater.jetpackcompose.ui.Home
import cn.jater.jetpackcompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme(viewModel.theme) {
                App(viewModel = viewModel)
            }
        }
    }

    override fun onBackPressed() {
        if (!viewModel.finishChat()) {
            super.onBackPressed()
        }
    }
}

@Composable
fun App(viewModel: WeViewModel) {
    Box {
        Home(viewModel = viewModel)
        ChatPage()
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreView() {
    val viewModel: WeViewModel = viewModel()
    WeComposeTheme(viewModel.theme) {
        App(viewModel = viewModel)
    }
}