package wolf.shin.earlyadopter.navigation

sealed class ScreenRouter(val route: String) {
    object Home : ScreenRouter("home")
    object NewsScreen : ScreenRouter("news")
}

enum class HomeRouter(val route: String) {
    ROOT("home/"),
    DETAIL("home/detail"),
}