package kun.sample.architecture.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object KeyModule {

    @Provides
    @UnsplashAccessKey
    fun provideUnSplashAccessKey() = "ae7Bh-kO8p1GWuup0Vc_-V8QoGdix1YbwHuxfBrwGEE"

}