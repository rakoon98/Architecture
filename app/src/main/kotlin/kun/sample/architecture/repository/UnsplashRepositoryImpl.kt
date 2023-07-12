package kun.sample.architecture.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepositoryImpl @Inject constructor(

) : UnsplashRepository {

    override suspend fun getPhotos(page: Int) {

    }

}