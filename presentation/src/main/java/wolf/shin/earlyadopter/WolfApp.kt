package wolf.shin.earlyadopter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import wolf.shin.earlyadopter.navigation.BottomNavigationBar
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme

@Composable
fun WolfApp() {
    AndroidEarlyAdopterTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavigationBar(navController = navController) }
        ) {
            WolfAppNavGraph(navController = navController)
        }
    }
}