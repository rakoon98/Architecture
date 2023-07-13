package kun.sample.architecture.ui.ui_container.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import kun.sample.architecture.data.internal.NavScreen
import kun.sample.architecture.ui.ui_container.state.AppState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArchitectureNavHost (
    modifier : Modifier = Modifier,
    startDestination : String = NavScreen.MainRoute.route,
    appState: AppState
){
    Scaffold(
        snackbarHost = { SnackbarHost(appState.snackBarHostState) },
        bottomBar = {
            if(appState.shouldShowBottomBar)
                HomeBottomNavigation(appState.navController)
        }
    ) {
        NavHost(
            modifier = modifier.padding(it),
            navController = appState.navController,
            startDestination = startDestination,
        ) {
            homeBottomNavigationGraph(appState)
        }
    }
}

