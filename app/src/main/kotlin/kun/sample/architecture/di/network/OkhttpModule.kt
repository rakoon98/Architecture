package kun.sample.architecture.di.network

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkhttpModule {

    @Singleton
    @Provides
    @UnsplashClient
    fun provideOkhttpUnsplash(@UnsplashAccessKey authorization: String): OkHttpClient =
        OkHttpClient.Builder()
            .run {
                addInterceptor(HeaderInterceptor(authorization))
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BASIC)
                    }
                )
                addInterceptor(OkHttpProfilerInterceptor())
            }
            .build()

    class HeaderInterceptor(private val authorization: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response =
            with(chain) {
                val request: Request = request().newBuilder()
                    .addHeader("Accept-Version", "v1")
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .addHeader("Authorization", authorization)
                    .build()

                proceed(request)
            }
    }

}