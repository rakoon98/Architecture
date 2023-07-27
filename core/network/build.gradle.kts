plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version "1.8.21"
}

android {
    namespace = "com.example.core.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.bundles.junit)

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.bundles.network)

    implementation(libs.hilt.android)
    implementation(libs.hilt.viewmodel)
    kapt(libs.hilt.compiler)
}