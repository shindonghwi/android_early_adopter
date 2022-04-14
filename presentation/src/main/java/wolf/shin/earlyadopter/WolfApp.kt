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
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        DockBarItem(name = "Home", route = "Home", defaultIcon = R.drawable.ic_dockbar_off_home, selectedIcon = R.drawable.ic_dockbar_on_home),
                        DockBarItem(name = "News", route = "News", defaultIcon = R.drawable.ic_dockbar_off_news, selectedIcon = R.drawable.ic_dockbar_on_news),
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        ) {
            InitNavigator(navController = navController)
        }
    }
}