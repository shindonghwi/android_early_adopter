package wolf.shin.earlyadopter.screen.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import wolf.shin.earlyadopter.component.image.ProfileImage
import wolf.shin.earlyadopter.screen.theme.Gray800

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
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically) {
        ProfileImage(
            modifier = Modifier.size(80.dp),
            imageUrl = "https://windowsforum.kr/files/attach/images/2966154/714/640/006/55e7d5ed1511affba0678ee977c7f40b.jpg"
        )

        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = "활동명이 필요해요!",
            style = MaterialTheme.typography.subtitle2,
            color = Gray800
        )
    }
}
