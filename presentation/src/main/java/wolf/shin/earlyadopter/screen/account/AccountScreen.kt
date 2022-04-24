package wolf.shin.earlyadopter.screen.account
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoreScreen(navigateToDetail: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AccountScreen",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { navigateToDetail() }) {
            Text("Move to DetailScreen")
        }
    }
}