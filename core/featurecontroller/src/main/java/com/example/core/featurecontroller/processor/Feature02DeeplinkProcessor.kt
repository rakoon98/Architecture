package com.example.core.featurecontroller.processor

import android.content.Context
import android.content.Intent
import com.example.core.featurecontroller.deeplink.DeeplinkProcessor
import com.example.feature.ui_02.Ui_02_MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature02DeeplinkProcessor @Inject constructor(
    private val context : Context
) : DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("feature02")
    }

    override fun execute(deeplink: String) {
//        val extras = deeplink.split("/feature01/").getOrNull(1)

        Intent(context, Ui_02_MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            putExtra("extraData", extras)
        }.also {
            context.startActivity(it)
        }
    }
}