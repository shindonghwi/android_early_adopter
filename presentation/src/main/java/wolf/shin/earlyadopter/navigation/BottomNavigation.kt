package wolf.shin.earlyadopter.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import wolf.shin.earlyadopter.model.DockBarItem

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    items: List<DockBarItem>,
    navController: NavHostController
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        items.forEach { tab ->
            val selected = tab.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { navController.navigate(tab.route) },
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = Color.LightGray,
                icon = {
                    Column {
                        Icon(
                            painterResource(id = if (selected) tab.selectedIcon else tab.defaultIcon),
                            contentDescription = tab.name
                        )
                        Text(
                            text = tab.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                        )
                    }
                }
            )
        }
    }
}