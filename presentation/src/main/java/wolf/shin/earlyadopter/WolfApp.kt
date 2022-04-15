package wolf.shin.earlyadopter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import wolf.shin.earlyadopter.model.DockBarItem
import wolf.shin.earlyadopter.navigation.BottomNavigationBar
import wolf.shin.earlyadopter.navigation.InitNavigator
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme
import wolf.shin.resource.R

@Composable
fun WolfApp() {
    AndroidEarlyAdopterTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { MyBottomNavigation(navController = navController) }
        ) {
            MyAppNavGraph(navController = navController)
        }
    }
}

enum class TabDirections(
    val route: String,
) {
    HOME("home"),
    COMPANY("news"),

}