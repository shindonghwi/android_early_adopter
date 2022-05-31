package wolf.shin.earlyadopter.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import wolf.shin.earlyadopter.model.DockBarItem
import wolf.shin.earlyadopter.model.screen_router.AccountScreenRouter
import wolf.shin.earlyadopter.model.screen_router.CompanyScreenRouter
import wolf.shin.earlyadopter.model.screen_router.HomeScreenRouter
import wolf.shin.earlyadopter.model.screen_router.NotificationScreenRouter

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {
    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: DockBarItem.HOME
            val tabs = DockBarItem.values().toList()

            BottomNavigation {
                tabs.forEach { tab ->
                    val route = tab.route
                    BottomNavigationItem(
                        icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = tab.route) },
                        label = { Text(text = route, fontSize = 9.sp) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == route,
                        onClick = {

                            // 바텀 메뉴 중복클릭 방지
                            if (currentRoute == "${route}/") {
                                return@BottomNavigationItem
                            }

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
        })
}

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private fun findTabRootRoute(tab: String): String {
    return when (tab) {
        DockBarItem.HOME.route -> HomeScreenRouter.ROOT.route
        DockBarItem.COMPANY.route -> CompanyScreenRouter.ROOT.route
        DockBarItem.NOTIFICATION.route -> NotificationScreenRouter.ROOT.route
        else -> AccountScreenRouter.ROOT.route
    }
}