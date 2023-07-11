package kun.sample.architecture.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UrlModule {

    @Provides
    @UnsplashBaseUrl
    fun provideBaseUrlUnsplash() = "https://api.unsplash.com/"

}