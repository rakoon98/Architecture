package kun.sample.architecture.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.featurecontroller.deeplink.DeeplinkHandler
import com.example.featurecontroller.model.APP_SCHEME_HOST
import dagger.hilt.android.AndroidEntryPoint
import kun.sample.architecture.compose.theme.ArchitectureTheme
import kun.sample.architecture.ui.ui_container.navigation.ArchitectureNavHost
import kun.sample.architecture.ui.ui_container.state.rememberAppState
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var deeplinkHandler : DeeplinkHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberAppState()
            ArchitectureTheme {
                ArchitectureNavHost(appState = appState)
            }
        }

        intent?.let { handleIntent(it) }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        // launchMode = singleTop 인 경우 해당 부분 에도 추가 해 줘야 한다.
        intent?.let { handleIntent(it) }
    }

    private fun handleIntent(intent: Intent) {
        intent.data?.toString()?.let {
            if(it.startsWith(APP_SCHEME_HOST)){
                deeplinkHandler.process(it)
                finish()
            }
        }
    }

}
