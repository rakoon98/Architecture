package kun.sample.architecture.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.featurecontroller.model.ControllerType

@Composable
fun HomeFavoriteScreen(
    onNext : () -> Unit,
    context : Context = LocalContext.current
) {
    Column() {
        Button(onClick = { onNext.invoke() }) {
            Text(
                modifier = Modifier,
                text = "그래프 탐색 버튼"
            )
        }
        Button(onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(ControllerType.Feature01().featureName))) }) {
            Text(
                modifier = Modifier,
                text = "딥링크 버튼"
            )
        }
        Button(onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(ControllerType.Feature01().getDeeplinkDepth1()))) }) {
            Text(
                modifier = Modifier,
                text = "딥링크 버튼 depth1"
            )
        }
        Button(onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(ControllerType.Feature01().getDeeplinkDepth2()))) }) {
            Text(
                modifier = Modifier,
                text = "딥링크 버튼 depth2"
            )
        }
    }
}