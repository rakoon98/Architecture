package kun.sample.architecture.di.network

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkhttpModule {

    @Singleton
    @Provides
    @UnsplashClient
    fun provideOkhttpUnSplash(@UnsplashAccessKey authorization : String): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor {
                val original: Request = it.request()

                val request: Request = original.newBuilder()
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .addHeader("Authorization", authorization)
                    .build()
                it.proceed(request)
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BASIC)
                }
            )
            .addInterceptor(OkHttpProfilerInterceptor())
            .build()


}