package kun.sample.architecture.data.remote.service

import kun.sample.architecture.data.remote.ApiResult
import kun.sample.architecture.data.remote.model.UnsplashPhotoModel
import kun.sample.architecture.data.type.UnsplashOrderType
import retrofit2.http.GET
import retrofit2.http.Query

interface UnSplashApiService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page : Int = 1,
        @Query("per_page") perPage : Int = 15,
        @Query("order_by") orderBy : String = UnsplashOrderType.LATEST.orderName
    ) : ApiResult<List<UnsplashPhotoModel>>

}