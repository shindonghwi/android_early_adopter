package wolf.shin.earlyadopter.screen.theme.font

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import wolf.shin.resource.R

val Pretendard = FontFamily(
    Font(R.font.pretendard_thin, FontWeight.W100),
    Font(R.font.pretendard_extralight, FontWeight.W200),
    Font(R.font.pretendard_light, FontWeight.W300),
    Font(R.font.pretendard_regular, FontWeight.W400),
    Font(R.font.pretendard_medium, FontWeight.W500),
    Font(R.font.pretendard_semibold, FontWeight.W600),
    Font(R.font.pretendard_bold, FontWeight.W700),
    Font(R.font.pretendard_extrabold, FontWeight.W800),
    Font(R.font.pretendard_black, FontWeight.W900)
)

val PretendardTypography = Typography(

    h1 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 28.sp,
        lineHeight = 34.sp
    ),
    h2 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    h3 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        lineHeight = 26.sp
    ),
    h4 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W700,
        fontSize = 18.sp,
        lineHeight = 22.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.02).em
    ),
    subtitle2 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.02).em
    ),
    caption = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.02).em
    )
)