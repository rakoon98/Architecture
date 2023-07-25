package com.example.featurecontroller.model

const val APP_SCHEME_HOST = "architecture://com.example.deeplink"

sealed class ControllerType(val featureName : String) {
    data class Feature01(val dummy : String = "") : ControllerType(featureName = "${APP_SCHEME_HOST}/feature01") {
        fun getDeeplinkDepth1() : String {
            return "${APP_SCHEME_HOST}/feature01/"
        }
        fun getDeeplinkDepth2() : String {
            return "${APP_SCHEME_HOST}/feature02/"
        }
    }
    data class Feature02(val dummy : String = "") : ControllerType("${APP_SCHEME_HOST}/feature02")
}