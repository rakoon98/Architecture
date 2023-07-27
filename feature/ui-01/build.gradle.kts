plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.example.ui_01"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    buildFeatures {
        compose = true
    }

}

dependencies {
    implementation(libs.bundles.junit)
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(platform(libs.kotlin.bom))

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

}