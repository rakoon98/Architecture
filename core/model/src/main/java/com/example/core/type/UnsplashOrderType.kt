package com.example.core.type

enum class UnsplashOrderType(val orderName : String) {
    LATEST("latest"), // default
    OLDEST("oldest"),
    POPULAR("popular"),
}