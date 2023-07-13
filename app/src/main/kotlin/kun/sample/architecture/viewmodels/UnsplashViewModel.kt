package kun.sample.architecture.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kun.sample.architecture.data.remote.ApiResult
import kun.sample.architecture.data.remote.model.UnsplashPhotoModel
import kun.sample.architecture.data.type.UnsplashOrderType
import kun.sample.architecture.repository.UnsplashRepository
import javax.inject.Inject

@HiltViewModel
class UnsplashViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    private val _imageFlow : MutableStateFlow<List<UnsplashPhotoModel>> = MutableStateFlow(emptyList())
    val imageFlow : StateFlow<List<UnsplashPhotoModel>> get() = _imageFlow.asStateFlow()

    fun getPhotos(page : Int = 1, orderBy : UnsplashOrderType = UnsplashOrderType.LATEST) = viewModelScope.launch {
        unsplashRepository.getPhotos(page = page, orderBy = orderBy)
            .onStart {  }
            .catch { err ->  }
            .onEach {
                when (it) {
                    is ApiResult.Success -> {
                        _imageFlow.value.toMutableList().apply {
                            addAll(it.data)
                        }.also { result -> _imageFlow.emit((result)) }
                    }
                    else -> {}
                }
            }
            .onCompletion {  }
            .stateIn(this, SharingStarted.Eagerly, false)
    }


}