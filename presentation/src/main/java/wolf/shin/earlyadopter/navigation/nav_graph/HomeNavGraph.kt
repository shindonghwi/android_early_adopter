package wolf.shin.earlyadopter.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import wolf.shin.earlyadopter.model.screen_router.HomeScreenRouter
import wolf.shin.earlyadopter.screen.detail.DetailScreen
import wolf.shin.earlyadopter.screen.home.HomeScreen


fun NavGraphBuilder.addHomeGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(HomeScreenRouter.ROOT.route) {
        HomeScreen {
            navController.navigate(HomeScreenRouter.DETAIL.route)
        }
    }
    composable(HomeScreenRouter.DETAIL.route) {
        DetailScreen(from = HomeScreenRouter.DETAIL.route)
    }
}