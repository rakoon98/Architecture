package com.example.featurecontroller.model

const val APP_SCHEME_HOST = "architecture://com.example.deeplink"

enum class ControllerType(val featureName : String) {
    Feature01("${APP_SCHEME_HOST}/feature01"),
    Feature02("${APP_SCHEME_HOST}/feature02")
}