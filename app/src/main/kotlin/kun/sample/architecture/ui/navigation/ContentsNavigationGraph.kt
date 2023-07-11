package kun.sample.architecture.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kun.sample.architecture.data.model.NavScreen
import kun.sample.architecture.ui.home.HomeScreen

fun NavGraphBuilder.contentsNavigationGraph(
    navController: NavHostController,
    startDestination: String = NavScreen.HOME.route
) {
    navigation(startDestination = startDestination, route = NavScreen.CONTENTS_ROUTE.route) {
        composable(NavScreen.HOME.route) { HomeScreen() }
    }
}