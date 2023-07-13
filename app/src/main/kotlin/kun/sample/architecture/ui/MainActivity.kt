package kun.sample.architecture.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import kun.sample.architecture.compose.theme.ArchitectureTheme
import kun.sample.architecture.ui.navigation.ArchitectureNavHost

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureTheme {
                ArchitectureNavHost()
            }
        }
    }
}
