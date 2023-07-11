package kun.sample.architecture.data.model

sealed class NavScreen(val route : String) {

    object CONTENTS_ROUTE: NavScreen("homeRoute")
    object HOME: NavScreen("home")

    object HOME_ROUTE: NavScreen("homeRoute")
    object HOME_MAIN: NavScreen("homeMain")
}
