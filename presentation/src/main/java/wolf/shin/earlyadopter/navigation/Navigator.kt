package wolf.shin.earlyadopter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import wolf.shin.earlyadopter.screen.home.HomeScreen
import wolf.shin.earlyadopter.screen.news.NewsScreen

@Composable
fun InitNavigator(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRouter.HomeScreen.route
    ) {
        composable(ScreenRouter.HomeScreen.route) {
            HomeScreen()
        }
        composable(ScreenRouter.NewsScreen.route) {
            NewsScreen()
        }
    }
}