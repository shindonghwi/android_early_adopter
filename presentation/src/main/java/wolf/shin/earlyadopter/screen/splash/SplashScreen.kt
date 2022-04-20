package wolf.shin.earlyadopter.screen.splash

import android.animation.ObjectAnimator
import android.os.Build
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

/** Splash 화면 설정 */
fun ComponentActivity.initSplashScreen(){
    installSplashScreen() // Activity 에 splash screen 설치
    setSplashEffect() // splash screen 효과 적용
}

/** Splash 화면 효과 적용 */
private fun ComponentActivity.setSplashEffect() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            ObjectAnimator.ofFloat(splashScreenView, View.TRANSLATION_Y, 0f, -splashScreenView.height.toFloat())
                .apply {
                    interpolator = AnticipateInterpolator() // 진행방향 뒤로 밀렸다가 진행방향으로 향함.
                    duration = 500L // 스플래시 화면 지속시간
                    doOnEnd { splashScreenView.remove() } // Splash Animation이 끝나면 뷰를 삭제한다.
                }.run {
                    start() // 애니매이션 시작
                }
        }
    }
}