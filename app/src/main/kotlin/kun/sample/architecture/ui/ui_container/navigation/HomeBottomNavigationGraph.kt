package kun.sample.architecture.ui.ui_container.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.ui_01.Ui_01_MainActivity
import com.example.ui_02.Ui_02_MainActivity
import kun.sample.architecture.data.internal.NavScreen
import kun.sample.architecture.ui.detail.ImgDetailScreen
import kun.sample.architecture.ui.home.HomeFavoriteScreen
import kun.sample.architecture.ui.home.HomeMainScreen
import kun.sample.architecture.ui.home.HomeMyPageScreen
import kun.sample.architecture.ui.ui_container.state.AppState

fun NavGraphBuilder.homeBottomNavigationGraph(
    appState: AppState,
    startDestination: String = NavScreen.Home.route,
    context : Context
) {
    navigation(startDestination = startDestination, route = NavScreen.MainRoute.route) {
        composable(NavScreen.Home.route) {
            HomeMainScreen { id ->
                appState.navigate(NavScreen.ImgDetail.toDetailRoute(id))
            }
        }
        composable(NavScreen.Favorite.route) {
            HomeFavoriteScreen(onNext = {
                context.startActivity(Intent(context, Ui_01_MainActivity::class.java))
            })
        }
        composable(NavScreen.MyPage.route) {
            HomeMyPageScreen(onNext = {
                context.startActivity(Intent(context, Ui_02_MainActivity::class.java))
            })
        }
        composable(
            NavScreen.ImgDetail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            ImgDetailScreen(id) {
                appState.navController.navigateUp()
            }
        }
    }
}