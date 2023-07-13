package kun.sample.architecture.di.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kun.sample.architecture.data.remote.adapter.NetworkCallAdapterFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    val jsonSerializationBuilder = Json {
        prettyPrint = true
        isLenient = true // Json 큰따옴표 느슨한 체크
        ignoreUnknownKeys = true // Field 값이 없는 경우 무시
        coerceInputValues = true // "null" 이 들어간 경우 Default Argument 대체

        encodeDefaults = true // 요청 시 Field가 DefaultValue or 아닐 경우에 종종 무시 되는 경우 방지

    }

    @Provides
    @Singleton
    @UnsplashRetrofit
    fun provideRetrofitUnsplash(
        @ConverterKotlinSerialization factory: Converter.Factory,
        @UnsplashClient okHttpClient: OkHttpClient,
        @UnsplashBaseUrl baseUrl: String,
        @CustomCallAdapterFactory callAdapterFactory : CallAdapter.Factory
    ): Retrofit = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        client(okHttpClient)
        addCallAdapterFactory(callAdapterFactory)
        addConverterFactory(factory)
    }.build()

}