package com.example.core.featurecontroller.deeplink

interface DeeplinkHandler {
    fun process(deeplink : String) : Boolean
}