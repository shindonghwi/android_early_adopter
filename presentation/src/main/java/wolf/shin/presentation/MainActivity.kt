package wolf.shin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import wolf.shin.presentation.screen.home.HomeScreen
import wolf.shin.presentation.screen.news.NewsScreen
import wolf.shin.presentation.screen.theme.AndroidEarlyAdopterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidEarlyAdopterTheme {

                SetNavHost(navController = rememberNavController())

            }
        }
    }
}


@Composable
fun SetNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("news") {
            NewsScreen()
        }
    }
}