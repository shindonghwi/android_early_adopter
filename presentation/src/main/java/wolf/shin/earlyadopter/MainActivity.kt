package wolf.shin.earlyadopter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import wolf.shin.earlyadopter.model.DockBarItem
import wolf.shin.earlyadopter.navigation.BottomNavigationBar
import wolf.shin.earlyadopter.navigation.InitNavigator
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme
import wolf.shin.resource.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidEarlyAdopterTheme {
                WolfApp()
            }
        }
    }
}