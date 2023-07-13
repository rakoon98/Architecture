package kun.sample.architecture.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kun.sample.architecture.data.remote.service.UnSplashApiService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideUnSplashService(@UnsplashRetrofit retrofit: Retrofit): UnSplashApiService =
        retrofit.create(UnSplashApiService::class.java)


}