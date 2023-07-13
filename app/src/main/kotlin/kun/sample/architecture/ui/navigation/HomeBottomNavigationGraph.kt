package kun.sample.architecture.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kun.sample.architecture.data.internal.NavScreen
import kun.sample.architecture.ui.home.HomeFavoriteScreen
import kun.sample.architecture.ui.home.HomeMainScreen
import kun.sample.architecture.ui.home.HomeMyPageScreen

fun NavGraphBuilder.homeBottomNavigationGraph(
    contentsNavController: NavHostController,
    bottomNavController: NavController,
    startDestination: String = NavScreen.HOME_MAIN.route
) {
    navigation(startDestination = startDestination, route = NavScreen.HOME_ROUTE.route) {
        composable(NavScreen.HOME_MAIN.route) { HomeMainScreen() }
        composable(NavScreen.HOME_FAVORITE.route) { HomeFavoriteScreen() }
        composable(NavScreen.HOME_MYPAGE.route) { HomeMyPageScreen() }
    }
}