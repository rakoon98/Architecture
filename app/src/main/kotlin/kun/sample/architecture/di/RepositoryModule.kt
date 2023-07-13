package kun.sample.architecture.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kun.sample.architecture.data.remote.service.UnSplashApiService
import kun.sample.architecture.repository.UnsplashRepository
import kun.sample.architecture.repository.UnsplashRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUnsplashRepository(unSplashApiService: UnSplashApiService) : UnsplashRepository =
        UnsplashRepositoryImpl(unSplashApiService)

}