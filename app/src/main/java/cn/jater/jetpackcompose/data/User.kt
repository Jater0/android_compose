package cn.jater.jetpackcompose.data

import androidx.annotation.DrawableRes
import cn.jater.jetpackcompose.R

class User(
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int
) {
    companion object {
        val me: User = User(id = "jater1_only", name = "Jater", avatar = R.drawable.avatar_rengwuxian)
    }
}