package kun.sample.architecture.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kun.sample.architecture.data.remote.service.UnSplashService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideUnSplashService(@UnsplashRetrofit retrofit: Retrofit): UnSplashService =
        retrofit.create(UnSplashService::class.java)


}