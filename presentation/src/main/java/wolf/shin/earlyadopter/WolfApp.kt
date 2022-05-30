package wolf.shin.earlyadopter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import wolf.shin.earlyadopter.model.DockBarItem
import wolf.shin.earlyadopter.navigation.BottomNavigationBar
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme

@Composable
fun WolfApp() {
    AndroidEarlyAdopterTheme {
        val navController = rememberNavController()
        val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

        BottomNavigationVisibleState(navController = navController, bottomBarState = bottomBarState)

        Scaffold(
            bottomBar = { BottomNavigationBar(navController = navController, bottomBarState = bottomBarState) }
        ) {
            WolfAppNavGraph(navController = navController)
        }
    }
}

@Composable
private fun BottomNavigationVisibleState(navController: NavHostController, bottomBarState: MutableState<Boolean>) {
    val scope = rememberCoroutineScope()

    navController.currentBackStackEntryFlow.let { backStackFlow ->
        LaunchedEffect(backStackFlow) {
            scope.launch {
                backStackFlow.collect {
                    when (it.destination.route.toString().replace("/", "")) {
                        DockBarItem.HOME.route,
                        DockBarItem.ACCOUNT.route,
                        DockBarItem.COMPANY.route,
                        DockBarItem.NOTIFICATION.route -> {
                            bottomBarState.value = true
                        }
                        else -> {
                            bottomBarState.value = false
                        }
                    }
                }
            }
        }
    }
}
