package kun.sample.architecture.ui.ui_container.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import kun.sample.architecture.data.internal.NavScreen
import kun.sample.architecture.ui.detail.ImgDetailScreen
import kun.sample.architecture.ui.home.HomeFavoriteScreen
import kun.sample.architecture.ui.home.HomeMainScreen
import kun.sample.architecture.ui.home.HomeMyPageScreen
import kun.sample.architecture.ui.ui_container.state.AppState

fun NavGraphBuilder.homeBottomNavigationGraph(
    appState: AppState,
    startDestination: String = NavScreen.Home.route
) {
    navigation(startDestination = startDestination, route = NavScreen.MainRoute.route) {
        composable(NavScreen.Home.route) {
            HomeMainScreen { id ->
                appState.navigate(NavScreen.ImgDetail.toDetailRoute(id))
            }
        }
        composable(NavScreen.Favorite.route) { HomeFavoriteScreen() }
        composable(NavScreen.MyPage.route) { HomeMyPageScreen() }
        composable(
            NavScreen.ImgDetail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            ImgDetailScreen(id)
        }
    }
}