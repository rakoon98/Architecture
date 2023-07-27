package kun.sample.architecture.ui.ui_container.state

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core.model.BottomNavItem
import com.example.core.model.NavScreen

@Composable
fun rememberAppState(
//    windowSizeClass: WindowSizeClass,
    scaffoldState: SnackbarHostState = remember { SnackbarHostState() },
    navController: NavHostController = rememberNavController(),
) : AppState {
    return remember(scaffoldState, navController) {
        AppState(scaffoldState, navController)
    }
}

@Stable
class AppState constructor(
    val snackBarHostState: SnackbarHostState,
    val navController: NavHostController,
    /** 그 외 필요한 내용들 가져다 두면 좋음. */
) {
//    val bottomBarTabs = /* State */

    val getBottomItems get() =
        listOf<BottomNavItem>(
            BottomNavItem("home", NavScreen.Home),
            BottomNavItem("favorite", NavScreen.Favorite),
            BottomNavItem("mypage", NavScreen.MyPage)
        )

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val shouldShowBottomBar: Boolean
        @Composable get() = currentDestination?.route in getBottomItems.map { it.route.route }



    fun navigateTo(route : String) {
        navController.navigate(route)
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    val currentRoute: String?
        get() = navController.currentDestination?.route

}