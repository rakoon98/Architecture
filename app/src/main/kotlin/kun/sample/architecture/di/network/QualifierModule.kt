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

/** Url */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnsplashBaseUrl