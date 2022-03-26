package cn.jater.jetpackcompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.jater.jetpackcompose.R
import cn.jater.jetpackcompose.ui.theme.WeComposeTheme

@Composable
fun WeBottomBar(selected: Int, onSelectedChange: (Int) -> Unit) {
    Row(Modifier.background(WeComposeTheme.colors.bottomBar)) {
        TabItem(
            iconId = if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            color = if (selected == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            desc = "聊天",
            modifier = Modifier
                .weight(1f)
                .clickable { onSelectedChange(0) }
        )
        TabItem(
            iconId = if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            color = if (selected == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            desc = "通讯录",
            modifier = Modifier
                .weight(1f)
                .clickable { onSelectedChange(1) }
        )
        TabItem(
            iconId = if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            color = if (selected == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            desc = "发现",
            modifier = Modifier
                .weight(1f)
                .clickable { onSelectedChange(2) }
        )
        TabItem(
            iconId = if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            color = if (selected == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            desc = "我",
            modifier = Modifier
                .weight(1f)
                .clickable { onSelectedChange(3) }
        )
    }
}

@Composable
private fun TabItem(modifier: Modifier = Modifier, @DrawableRes iconId: Int, desc: String = "Title", color: Color) {
    Column(
        modifier.padding(vertical = 8.dp),
        // 横向居中
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painterResource(id = iconId), contentDescription = desc, Modifier.size(24.dp), tint = color)
        Text(text = desc, fontSize = 11.sp, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun WebBottomBarDarkPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        var selectedTab by remember { mutableStateOf(0) }
        WeBottomBar(selected = selectedTab) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WebBottomBarLightPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Light) {
        var selectedTab by remember { mutableStateOf(0) }
        WeBottomBar(selected = selectedTab) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WebBottomBarCNYPreview() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        var selectedTab by remember { mutableStateOf(0) }
        WeBottomBar(selected = selectedTab) {
            selectedTab = it
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TabItemPreView() {
    TabItem(iconId = R.drawable.ic_chat_outlined, color = WeComposeTheme.colors.icon, desc = "聊天")
}