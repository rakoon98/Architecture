package kun.sample.architecture.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.example.core.network.ApiResult
import kun.sample.architecture.data.remote.model.UnsplashPhotoModel
import kun.sample.architecture.data.remote.service.UnSplashApiService
import com.example.core.type.UnsplashOrderType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashService : UnSplashApiService
) : UnsplashRepository {

    override suspend fun getPhotos(
        page: Int,
        perPage: Int,
        orderBy: UnsplashOrderType
    ): Flow<ApiResult<List<UnsplashPhotoModel>>> = flow<ApiResult<List<UnsplashPhotoModel>>> {
        emit(unsplashService.getPhotos(page, perPage, orderBy.orderName))
    }.flowOn(Dispatchers.IO)

}