package com.example.featurecontroller.di

import com.example.featurecontroller.deeplink.DeeplinkProcessor
import com.example.featurecontroller.processor.Feature01DeeplinkProcessor
import com.example.featurecontroller.processor.Feature02DeeplinkProcessor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
interface DeeplinkProcessorModule {

    @Binds
    @IntoSet
    fun bindFeature01Processors(feature01DeeplinkProcessor : Feature01DeeplinkProcessor): DeeplinkProcessor

    @Binds
    @IntoSet
    fun bindFeature02Processors(feature02DeeplinkProcessor : Feature02DeeplinkProcessor): DeeplinkProcessor



}