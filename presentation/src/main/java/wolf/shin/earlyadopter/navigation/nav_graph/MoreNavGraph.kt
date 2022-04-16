package wolf.shin.earlyadopter.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import wolf.shin.earlyadopter.model.screen_router.MoreScreenRouter
import wolf.shin.earlyadopter.screen.detail.DetailScreen
import wolf.shin.earlyadopter.screen.more.MoreScreen


fun NavGraphBuilder.addMoreGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(MoreScreenRouter.ROOT.route) {
        MoreScreen {
            navController.navigate(MoreScreenRouter.DETAIL.route)
        }
    }
    composable(MoreScreenRouter.DETAIL.route) {
        DetailScreen(from = MoreScreenRouter.DETAIL.route)
    }
}