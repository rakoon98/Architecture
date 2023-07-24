package kun.sample.architecture.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.featurecontroller.model.ControllerType

@Composable
fun HomeMyPageScreen(context : Context = LocalContext.current) {
    Button(onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(ControllerType.Feature02.featureName))) }) {
        Text(
            modifier = Modifier,
            text = "MyPage -> Move"
        )
    }
}