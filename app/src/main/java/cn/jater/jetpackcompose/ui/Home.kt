package cn.jater.jetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import cn.jater.jetpackcompose.WeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(viewModel: WeViewModel) {
    Column {
        val pagerState = rememberPagerState()
        HorizontalPager(
            count = 4,
            modifier = Modifier.weight(1f),
            state = pagerState
        ) { page ->
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> ContactList()
                2 -> DiscoveryList()
                3 -> MeList()
            }
        }
        val scope = rememberCoroutineScope()
        // 不显示 viewModel.selectedTab，改为 pagerState.currentPage
        WeBottomBar(selected = pagerState.currentPage) { page ->
            scope.launch {
                pagerState.animateScrollToPage(page = page)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreView() {
    val viewModel: WeViewModel = viewModel()
    Home(viewModel = viewModel)
}