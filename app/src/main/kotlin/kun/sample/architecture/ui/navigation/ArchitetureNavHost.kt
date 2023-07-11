package kun.sample.architecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kun.sample.architecture.data.model.NavScreen

@Composable
fun ArchitectureNavHost (
    modifier : Modifier = Modifier,
    navController : NavHostController = rememberNavController(),
    startDestination : String = NavScreen.CONTENTS_ROUTE.route
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        contentsNavigationGraph(navController)
    }
}

