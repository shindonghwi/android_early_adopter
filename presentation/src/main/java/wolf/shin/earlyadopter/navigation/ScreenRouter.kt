package wolf.shin.earlyadopter.navigation

sealed class ScreenRouter(val route: String) {
    object HomeScreen : ScreenRouter("home")
    object NewsScreen : ScreenRouter("news")
}