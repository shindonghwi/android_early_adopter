package wolf.shin.earlyadopter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import wolf.shin.earlyadopter.model.DockBarItem
import wolf.shin.earlyadopter.model.screen_router.CompanyScreenRouter
import wolf.shin.earlyadopter.model.screen_router.HomeScreenRouter
import wolf.shin.earlyadopter.model.screen_router.MoreScreenRouter
import wolf.shin.earlyadopter.model.screen_router.NotificationScreenRouter
import wolf.shin.earlyadopter.navigation.nav_graph.addCompanyGraph
import wolf.shin.earlyadopter.navigation.nav_graph.addHomeGraph
import wolf.shin.earlyadopter.navigation.nav_graph.addMoreGraph
import wolf.shin.earlyadopter.navigation.nav_graph.addNotificationGraph

/** 화면 */
@Composable
fun WolfAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = DockBarItem.HOME.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = DockBarItem.HOME.route,
            startDestination = HomeScreenRouter.ROOT.route,
        ) {
            addHomeGraph(modifier, navController)
        }

        navigation(
            route = DockBarItem.COMPANY.route,
            startDestination = CompanyScreenRouter.ROOT.route,
        ) {
            addCompanyGraph(modifier, navController)
        }

        navigation(
            route = DockBarItem.NOTIFICATION.route,
            startDestination = NotificationScreenRouter.ROOT.route,
        ) {
            addNotificationGraph(modifier, navController)
        }

        navigation(
            route = DockBarItem.MORE.route,
            startDestination = MoreScreenRouter.ROOT.route,
        ) {
            addMoreGraph(modifier, navController)
        }
    }
}