package cn.jater.jetpackcompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.jater.jetpackcompose.R
import cn.jater.jetpackcompose.data.User
import cn.jater.jetpackcompose.ui.theme.WeComposeTheme

@Composable
fun MeListTopBar() {
    Row(
        Modifier
            .background(WeComposeTheme.colors.listItem)
            .fillMaxWidth()
            .height(224.dp)
    ) {
        Image(
            painterResource(id = R.drawable.avatar_rengwuxian), contentDescription = "Me",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 24.dp)
                .clip(RoundedCornerShape(6.dp))
                .size(100.dp)
        )
        Column(
            Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                User.me.name,
                Modifier.padding(top = 64.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = WeComposeTheme.colors.textPrimary
            )
            Text(
                "微信号：${User.me.id}",
                Modifier.padding(top = 10.dp),
                fontSize = 14.sp,
                color = WeComposeTheme.colors.textSecondary
            )
            Text(
                "+ 状态",
                Modifier
                    .padding(top = 16.dp)
                    .border(1.dp, WeComposeTheme.colors.onBackground, RoundedCornerShape(50))
                    .padding(8.dp, 2.dp),
                fontSize = 16.sp,
                color = WeComposeTheme.colors.onBackground
            )
        }
        Icon(
            painterResource(id = R.drawable.ic_qrcode), contentDescription = "qrcode",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 20.dp)
                .size(14.dp),
            tint = WeComposeTheme.colors.onBackground
        )
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp)
                .size(16.dp),
            tint = WeComposeTheme.colors.more
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MeListTopBarPreview() {
    MeListTopBar()
}

@Composable
fun MeListItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(icon), "title", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )
        Text(
            title,
            fontSize = 17.sp,
            color = WeComposeTheme.colors.textPrimary
        )
        badge?.invoke()
        Spacer(Modifier.weight(1f))
        endBadge?.invoke()
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(16.dp),
            tint = WeComposeTheme.colors.more
        )
    }
}

@Composable
fun MeList() {
    Box(
        Modifier
            .background(WeComposeTheme.colors.background)
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .background(WeComposeTheme.colors.listItem)
                .fillMaxWidth()
        ) {
            MeListTopBar()
            Spacer(
                Modifier
                    .background(WeComposeTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            MeListItem(R.drawable.ic_pay, "支付")
            Spacer(
                Modifier
                    .background(WeComposeTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            MeListItem(R.drawable.ic_collections, "收藏")
            Divider(startIndent = 56.dp, color = WeComposeTheme.colors.chatListDivider, thickness = 0.8f.dp)
            MeListItem(R.drawable.ic_photos, "朋友圈")
            Divider(startIndent = 56.dp, color = WeComposeTheme.colors.chatListDivider, thickness = 0.8f.dp)
            MeListItem(R.drawable.ic_cards, "卡包")
            Divider(startIndent = 56.dp, color = WeComposeTheme.colors.chatListDivider, thickness = 0.8f.dp)
            MeListItem(R.drawable.ic_stickers, "表情")
            Spacer(
                Modifier
                    .background(WeComposeTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            MeListItem(R.drawable.ic_settings, "设置")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeListPreview() {
    WeComposeTheme {
        MeList()
    }
}