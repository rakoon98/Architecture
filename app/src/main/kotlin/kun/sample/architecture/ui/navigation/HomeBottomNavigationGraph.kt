package kun.sample.architecture.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import kun.sample.architecture.data.model.NavScreen
import kun.sample.architecture.ui.home.HomeMainScreen

fun NavGraphBuilder.homeBottomNavigationGraph(
    contentsNavController: NavHostController,
    bottomNavController: NavController,
    startDestination: String = NavScreen.HOME_MAIN.route
) {
    navigation(startDestination = startDestination, route = NavScreen.HOME_ROUTE.route) {
        composable(NavScreen.HOME_MAIN.route) { HomeMainScreen() }
        composable(NavScreen.HOME_FAVORITE.route) { HomeMainScreen() }
        composable(NavScreen.HOME_MYPAGE.route) { HomeMainScreen() }
    }
}