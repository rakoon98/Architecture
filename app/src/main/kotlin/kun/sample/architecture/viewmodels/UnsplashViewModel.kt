package kun.sample.architecture.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kun.sample.architecture.repository.UnsplashRepository
import kun.sample.architecture.repository.UnsplashRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class UnsplashViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    fun getPhotos() = viewModelScope.launch {
        unsplashRepository.getPhotos()
            .onStart { Log.d("데이터체크", "onStart") }
            .catch { err -> Log.d("데이터체크", "에러 : $err") }
            .onEach {
                Log.d("데이터체크", "onEach : $it")
            }
            .onCompletion { Log.d("데이터체크", "onCompletion") }
            .stateIn(this, SharingStarted.Eagerly, false)
    }


}