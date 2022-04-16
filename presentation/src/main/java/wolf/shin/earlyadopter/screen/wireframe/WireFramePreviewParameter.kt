package wolf.shin.earlyadopter.screen.wireframe

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import wolf.shin.earlyadopter.model.screen_router.HomeScreenRouter

/** 전체 앱 흐름(와이어프레임)을 보기위한 프리뷰 파라미터 제작 */
class WireFramePreviewParameter : PreviewParameterProvider<String> {
    override val values = sequenceOf(

        // home
        HomeScreenRouter.ROOT.route,
        HomeScreenRouter.DETAIL.route

    )
}