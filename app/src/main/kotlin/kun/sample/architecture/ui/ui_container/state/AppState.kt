package kun.sample.architecture.ui.ui_container.state

import android.app.Activity
import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kun.sample.architecture.data.internal.BottomNavItem
import kun.sample.architecture.data.internal.NavScreen

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

    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in getBottomItems.map { it.route.route }

    fun navigate(route : String) {
        navController.navigate(route)
    }

}