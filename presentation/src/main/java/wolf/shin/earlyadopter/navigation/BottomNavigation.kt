package wolf.shin.earlyadopter.navigation

import android.media.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import wolf.shin.earlyadopter.TabDirections
import wolf.shin.earlyadopter.model.DockBarItem

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    items: List<DockBarItem>,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry?.destination?.route ?: TabDirections.HOME
    val tabs = TabDirections.values().toList()
    BottomNavigation {
        tabs.forEach { tab ->
            val route = tab.route
            BottomNavigationItem(
                icon = {
                    Image(
                        painterResource(tab.icon),
                        contentDescription = "",
                    )
                },
                label = { Text(text = route, fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute.toString().startsWith(route)) {
                        navController.navigate(findTabRootRoute(route)) {
                            popUpTo(findStartDestination(navController.graph).id)
                        }
                    } else if (route != currentRoute) {
                        navController.navigate(route) {
                            launchSingleTop = true
                            restoreState = true
                            val startDestination = findStartDestination(navController.graph)
                            popUpTo(startDestination.id) {
                                saveState = true
                            }
                        }
                    }
                }
            )
        }
    }
}


private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private fun findTabRootRoute(tab: String): String {
    return when (tab) {
        TabDirections.HOME.route -> HomeDirections.ROOT.route
        TabDirections.COMPANY.route -> CompanyDirections.ROOT.route
        TabDirections.NOTIFICATION.route -> NotificationDirections.ROOT.route
        else -> MoreDirections.ROOT.route
    }
}