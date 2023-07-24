package com.example.featurecontroller.di

import android.content.Context
import com.example.featurecontroller.deeplink.DeeplinkHandler
import com.example.featurecontroller.deeplink.DeeplinkProcessor
import com.example.featurecontroller.deeplink.DefaultDeeplinkHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context : Context) : Context = context

    @Provides
    @Singleton
    fun provideDefaultDeeplinkHandler(
        processors : Set<@JvmSuppressWildcards DeeplinkProcessor>
    ) : DeeplinkHandler = DefaultDeeplinkHandler(processors)

//    @Provides
//    @Singleton
//    fun provideController(defaultHandler : DefaultDeeplinkHandler) : UiController = UiController(defaultHandler)

}