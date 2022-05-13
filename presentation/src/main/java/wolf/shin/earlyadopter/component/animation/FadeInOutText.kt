package wolf.shin.earlyadopter.component.animation

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable

/** Composable Function의 알파값을 조정한다. */
@Composable
fun fadeInOutEffectAnimation(
    minAlpha: Float = 0f,
    maxAlpha: Float = 1f,
    duration: Int = 800,
    repeatMode: RepeatMode = RepeatMode.Reverse
) = rememberInfiniteTransition().animateFloat(
    initialValue = minAlpha,
    targetValue = maxAlpha,
    animationSpec = infiniteRepeatable(
        animation = tween(durationMillis = duration),
        repeatMode = repeatMode
    )
).value
