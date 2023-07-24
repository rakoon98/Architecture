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
fun HomeFavoriteScreen(
    context : Context = LocalContext.current
) {

    Button(onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(ControllerType.Feature01.featureName))) }) {
        Text(
            modifier = Modifier,
            text = "Favorite -> Move"
        )
    }
}