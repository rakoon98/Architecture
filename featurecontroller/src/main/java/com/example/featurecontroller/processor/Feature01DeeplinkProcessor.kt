package com.example.featurecontroller.processor

import android.content.Context
import android.content.Intent
import com.example.featurecontroller.deeplink.DeeplinkProcessor
import com.example.ui_01.Ui_01_MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Feature01DeeplinkProcessor @Inject constructor(
    private val context : Context
) : DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("feature01")
    }

    override fun execute(deeplink: String) {
//        val extras = deeplink.split("/feature01/").getOrNull(1)

        Intent(context, Ui_01_MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            putExtra("extraData", extras)
        }.also {
            context.startActivity(it)
        }
    }
}