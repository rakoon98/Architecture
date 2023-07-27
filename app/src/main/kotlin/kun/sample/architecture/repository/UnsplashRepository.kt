package kun.sample.architecture.repository

import kotlinx.coroutines.flow.Flow
import com.example.core.network.ApiResult
import kun.sample.architecture.data.remote.model.UnsplashPhotoModel
import com.example.core.type.UnsplashOrderType

interface UnsplashRepository {

    suspend fun getPhotos(
        page : Int = 1,
        perPage : Int = 30,
        orderBy : UnsplashOrderType = UnsplashOrderType.LATEST
    ): Flow<ApiResult<List<UnsplashPhotoModel>>>

}
