package wolf.shin.earlyadopter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import wolf.shin.earlyadopter.navigation.HomeRouter
import wolf.shin.earlyadopter.screen.home.addHomeGraph

@Composable
fun MyAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = TabDirections.HOME.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = TabDirections.HOME.route,
            startDestination = HomeRouter.ROOT.route,
        ) {
            addHomeGraph(modifier, navController)
        }
    }
}