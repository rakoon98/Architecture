package kun.sample.architecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kun.sample.architecture.data.model.NavScreen
import kun.sample.architecture.ui.home.HomeScreen

fun NavGraphBuilder.contentsNavigationGraph(
    navController: NavController,
    startDestination: String = NavScreen.HOME.route
) {
    navigation(startDestination = startDestination, route = NavScreen.CONTENTS_ROUTE.route) {
        composable(NavScreen.HOME.route) { HomeScreen() }
    }
}