package kun.sample.architecture.repository

interface UnsplashRepository {

    suspend fun getPhotos(page : Int)

}