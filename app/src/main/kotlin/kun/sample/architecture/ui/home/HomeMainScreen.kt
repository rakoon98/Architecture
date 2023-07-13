package kun.sample.architecture.ui.home

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import kun.sample.architecture.viewmodels.UnsplashViewModel

@Composable
fun HomeMainScreen(
    unsplashViewModel : UnsplashViewModel = hiltViewModel()
) {

    Button(onClick = { unsplashViewModel.getPhotos() }) {
        Text(text = "HOME")
    }

}