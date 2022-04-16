package wolf.shin.earlyadopter.navigation.nav_graph
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import wolf.shin.earlyadopter.model.screen_router.CompanyScreenRouter
import wolf.shin.earlyadopter.screen.company.CompanyScreen
import wolf.shin.earlyadopter.screen.detail.DetailScreen

fun NavGraphBuilder.addCompanyGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(CompanyScreenRouter.ROOT.route) {
        CompanyScreen {
            navController.navigate(CompanyScreenRouter.DETAIL.route)
        }
    }
    composable(CompanyScreenRouter.DETAIL.route) {
        DetailScreen(from = CompanyScreenRouter.DETAIL.route) {
            Button(onClick = {
                navController.navigate(CompanyScreenRouter.DETAIL2.route)
            }) {
                Text("Move To Detail 2")
            }
        }
    }

    composable(CompanyScreenRouter.DETAIL2.route) {
        DetailScreen(from = CompanyScreenRouter.DETAIL.route + "2")
    }
}