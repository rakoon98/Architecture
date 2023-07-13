package kun.sample.architecture.di.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kun.sample.architecture.data.remote.adapter.NetworkCallAdapterFactory
import kun.sample.architecture.di.network.RetrofitModule.jsonSerializationBuilder
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.CallAdapter
import retrofit2.Converter

@Module
@InstallIn(SingletonComponent::class)
object FactoryModule {

    @Provides
    @ConverterKotlinSerialization
    fun provideKotlinConverterFactory(): Converter.Factory {
        return jsonSerializationBuilder.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @CustomCallAdapterFactory
    fun provideCallAdapterFactory() : CallAdapter.Factory {
        return NetworkCallAdapterFactory()
    }

}