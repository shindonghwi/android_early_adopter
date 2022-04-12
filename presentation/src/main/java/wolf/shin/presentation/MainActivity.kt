package wolf.shin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import wolf.shin.presentation.model.DockBarItem
import wolf.shin.presentation.navigation.BottomNavigationBar
import wolf.shin.presentation.navigation.InitNavigator
import wolf.shin.presentation.screen.theme.AndroidEarlyAdopterTheme
import wolf.shin.resource.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidEarlyAdopterTheme {

                val navController = rememberNavController()

                MainView(navController)

            }
        }
    }
}

@Composable
private fun MainView(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    DockBarItem(
                        name = "Home",
                        route = "Home",
                        defaultIcon = R.drawable.ic_dockbar_off_home,
                        selectedIcon = R.drawable.ic_dockbar_on_home
                    ),
                    DockBarItem(
                        name = "News",
                        route = "News",
                        defaultIcon = R.drawable.ic_dockbar_off_news,
                        selectedIcon = R.drawable.ic_dockbar_on_news
                    ),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        }
    ) {
        InitNavigator(navController = navController)
    }
}