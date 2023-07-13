package kun.sample.architecture.repository

import kotlinx.coroutines.flow.Flow
import kun.sample.architecture.data.remote.ApiResult
import kun.sample.architecture.data.remote.model.UnsplashPhotoModel
import kun.sample.architecture.data.type.UnsplashOrderType
import retrofit2.http.Query

interface UnsplashRepository {

    suspend fun getPhotos(
        page : Int = 1,
        perPage : Int = 30,
        orderBy : UnsplashOrderType = UnsplashOrderType.LATEST
    ): Flow<ApiResult<List<UnsplashPhotoModel>>>

}
