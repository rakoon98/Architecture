package com.example.core.model

sealed class NavScreen(val route : String) {

    object MainRoute: NavScreen("mainRoute")
    object Home: NavScreen("main")
    object Favorite: NavScreen("favorite")
    object MyPage: NavScreen("myPage")

    object ImgDetail : NavScreen("imgDetail/{id}") {
        fun toDetailRoute(id : String) : String {
            return "imgDetail/$id"
        }
    }

}
