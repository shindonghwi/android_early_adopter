package wolf.shin.earlyadopter.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import dev.wolf.skeleton_ui.SkeletonView
import wolf.shin.resource.R

@Composable
fun ProfileImage(modifier: Modifier, imageUrl: String) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .size(160)
            .build(),
        contentDescription = "profile",
        contentScale = ContentScale.Crop
    ) {
        val profileModifier = modifier.then(Modifier.clip(CircleShape))

        when (painter.state) {

            // 프로필 이미지 로딩중..
            is AsyncImagePainter.State.Loading -> {
                SkeletonView(modifier = profileModifier, repeatDelayTime = 200, speed = 800)
            }

            // 프로필 이미지 로딩실패
            is AsyncImagePainter.State.Error -> {
                Image(
                    modifier = profileModifier,
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "profile"
                )
            }

            // 프로필 이미지 로딩성공
            else -> {
                SubcomposeAsyncImageContent(modifier = profileModifier)
            }
        }
    }
}