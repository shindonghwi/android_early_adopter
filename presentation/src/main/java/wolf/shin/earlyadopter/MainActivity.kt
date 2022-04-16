package wolf.shin.earlyadopter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme

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