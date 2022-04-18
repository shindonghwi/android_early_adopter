package wolf.shin.earlyadopter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            AndroidEarlyAdopterTheme {
                WolfApp()
            }
        }
    }
}