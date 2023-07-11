package kun.sample.architecture.di.network

import javax.inject.Qualifier

/** Converter */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ConverterKotlinSerialization


/** Client */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnsplashClient

/** Retrofit */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnsplashRetrofit

/** Url */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnsplashBaseUrl

/** Const */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnsplashAccessKey
