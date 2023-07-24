package com.example.featurecontroller.controller

import android.content.Intent
import com.example.featurecontroller.deeplink.DefaultDeeplinkHandler
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UiController @Inject constructor(
    private val deeplinkHandler: DefaultDeeplinkHandler
) {

    fun handleIntent(intent : Intent) {
        intent.data?.toString()?.let {
            deeplinkHandler.process(it)
        }
    }

}