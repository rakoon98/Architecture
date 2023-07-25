package com.example.featurecontroller.deeplink

interface DeeplinkHandler {
    fun process(deeplink : String) : Boolean
}