package wolf.shin.earlyadopter.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import wolf.shin.earlyadopter.model.screen_router.NotificationScreenRouter
import wolf.shin.earlyadopter.screen.detail.DetailScreen
import wolf.shin.earlyadopter.screen.notification.NotificationScreen


fun NavGraphBuilder.addNotificationGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(NotificationScreenRouter.ROOT.route) {
        NotificationScreen {
            navController.navigate(NotificationScreenRouter.DETAIL.route)
        }
    }
    composable(NotificationScreenRouter.DETAIL.route) {
        DetailScreen(from = NotificationScreenRouter.DETAIL.route)
    }
}