package kun.sample.architecture.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface UnSplashService {

    @GET("photos")
    suspend fun getPhotos(@Query("page") page : Int = 0)

}