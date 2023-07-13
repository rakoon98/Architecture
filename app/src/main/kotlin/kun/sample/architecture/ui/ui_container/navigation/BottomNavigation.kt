package kun.sample.architecture.ui.ui_container.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import kun.sample.architecture.data.internal.BottomNavItem
import kun.sample.architecture.data.internal.NavScreen

@Composable
fun HomeBottomNavigation(navController : NavController) {
    BottomNavigation(backgroundColor = Color.White, contentColor = Color.Black) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        getBottomItems.forEach {
            val isSelected = currentDestination?.hierarchy?.any { dest -> dest.route == it.route.route } == true
            HomeBottomItem(it, isSelected) { navScreen ->
                navController.navigate(navScreen.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }
        }
    }
}

@Composable
fun RowScope.HomeBottomItem(
    item : BottomNavItem,
    isSelected : Boolean,
    onClick : (NavScreen) -> Unit
) {
    BottomNavigationItem(
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        label = { Text(item.title) },
        selected = isSelected,
        onClick = { onClick.invoke(item.route) }
    )
}

val getBottomItems get() =
    listOf<BottomNavItem>(
        BottomNavItem("home", NavScreen.Home),
        BottomNavItem("favorite", NavScreen.Favorite),
        BottomNavItem("mypage", NavScreen.MyPage)
    )