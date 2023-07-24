package com.example.featurecontroller.deeplink

interface DeeplinkProcessor {
    fun matches(deeplink : String) : Boolean
    fun execute(deeplink : String)
}