package wolf.shin.earlyadopter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import wolf.shin.earlyadopter.screen.splash.initSplashScreen
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initSplashScreen() // 스플래시 화면 셋팅
        super.onCreate(savedInstanceState)
        setContent {
            AndroidEarlyAdopterTheme {
                WolfApp()
            }
        }
    }
}