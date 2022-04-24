package wolf.shin.earlyadopter.screen.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wolf.shin.earlyadopter.component.animation.fadeInOutEffectAnimation
import wolf.shin.earlyadopter.component.image.ProfileImage
import wolf.shin.earlyadopter.screen.theme.Gray600
import wolf.shin.resource.R

@Composable
fun AccountScreen(navigateToDetail: () -> Unit) {

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column {
            AccountInfo()
        }
    }
}

@Composable
private fun AccountInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileImage(
            modifier = Modifier.size(80.dp),
            imageUrl = "https://windowsforum.kr/files/attach/images/2966154/714/640/006/55e7d5ed1511affba0678ee977c7f40b.jpg"
        )

        Text(
            modifier = Modifier
                .padding(start = 12.dp)
                .alpha(fadeInOutEffectAnimation(minAlpha = 0.1f, maxAlpha = 1f, duration = 1500)),
            text = stringResource(id = R.string.accountRoot_title),
            style = MaterialTheme.typography.subtitle1,
            color = Gray600
        )

    }
}
