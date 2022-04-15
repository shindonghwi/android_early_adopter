package wolf.shin.earlyadopter.screen.home
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

enum class HomeDirections(val route: String) {
    ROOT("home/"),
    DETAIL("home/detail"),
}

fun NavGraphBuilder.addHomeGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(HomeDirections.ROOT.route) {
        HomeScreen {
            navController.navigate(HomeDirections.DETAIL.route)
        }
    }
    composable(HomeDirections.DETAIL.route) {
        DetailScreen(from = HomeDirections.DETAIL.route)
    }
}