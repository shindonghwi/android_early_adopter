package wolf.shin.earlyadopter.screen.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import wolf.shin.earlyadopter.navigation.HomeRouter
import wolf.shin.earlyadopter.screen.home.detail.HomeDetail

fun NavGraphBuilder.addHomeGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(HomeRouter.ROOT.route) {
        HomeScreen {
            navController.navigate(HomeRouter.DETAIL.route)
        }
    }
    composable(HomeRouter.DETAIL.route) {
        HomeDetail(from = HomeRouter.DETAIL.route)
    }
}