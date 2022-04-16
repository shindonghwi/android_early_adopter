package wolf.shin.earlyadopter.model

import androidx.annotation.DrawableRes
import wolf.shin.resource.R

enum class DockBarItem(
    val route: String,
    @DrawableRes val icon: Int
) {
    HOME("home", R.drawable.ic_dockbar_on_home),
    COMPANY("company", R.drawable.ic_dockbar_on_home),
    NOTIFICATION("notification", R.drawable.ic_dockbar_on_home),
    MORE("more", R.drawable.ic_dockbar_on_home),
}