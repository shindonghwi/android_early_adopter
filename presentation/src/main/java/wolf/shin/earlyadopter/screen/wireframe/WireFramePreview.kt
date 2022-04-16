package wolf.shin.earlyadopter.screen.wireframe

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import wolf.shin.earlyadopter.model.screen_router.CompanyScreenRouter
import wolf.shin.earlyadopter.model.screen_router.HomeScreenRouter
import wolf.shin.earlyadopter.screen.detail.DetailScreen
import wolf.shin.earlyadopter.screen.home.HomeScreen
import wolf.shin.earlyadopter.screen.theme.AndroidEarlyAdopterTheme

/** 전체 앱 흐름 ( 와이어프레임 ) 을 보기 위한 Function
 *
 * 같은 폴더인 WireFramePreviewParameter 에 의해서 화면이 제작된다.
 *
 * */
@Preview(showBackground = true)
@Composable
fun WolfAppPreview(@PreviewParameter(WireFramePreviewParameter::class) screen: String) {
    AndroidEarlyAdopterTheme {

        // 홈
        if (screen.contains(HomeScreenRouter.ROOT.route)) {

            when (screen) {
                HomeScreenRouter.ROOT.route -> HomeScreen {}
                HomeScreenRouter.DETAIL.route -> DetailScreen(from = CompanyScreenRouter.DETAIL.route + "2")
            }

        }
    }
}
