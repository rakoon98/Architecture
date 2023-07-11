package kun.sample.architecture.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kun.sample.architecture.data.model.NavScreen
import kun.sample.architecture.ui.navigation.HomeBottomNavigation
import kun.sample.architecture.ui.navigation.homeBottomNavigationGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    contentsNavController: NavHostController = rememberNavController(),
    bottomNavController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { HomeBottomNavigation(bottomNavController) }
    ) {
        NavHost(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(
                    PaddingValues(it.calculateTopPadding(), 0.dp, 0.dp, it.calculateBottomPadding())
                ),
            navController = bottomNavController,
            startDestination = NavScreen.HOME_ROUTE.route
        ) {
            homeBottomNavigationGraph(contentsNavController, bottomNavController)
        }
    }
}