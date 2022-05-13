package wolf.shin.earlyadopter.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import wolf.shin.earlyadopter.model.screen_router.AccountScreenRouter
import wolf.shin.earlyadopter.screen.detail.DetailScreen
import wolf.shin.earlyadopter.screen.account.AccountScreen


fun NavGraphBuilder.addAccountGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(AccountScreenRouter.ROOT.route) {
        AccountScreen {
            navController.navigate(AccountScreenRouter.DETAIL.route)
        }
    }
    composable(AccountScreenRouter.DETAIL.route) {
        DetailScreen(from = AccountScreenRouter.DETAIL.route)
    }
}