import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.oxygenik.moviz"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.oxygenik.moviz"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Apikey retrieval from the local.properties
        val tmbApiKey = gradleLocalProperties(rootDir, providers).getProperty("TMDB_API_KEY") ?: ""

        buildConfigField(
            "String",
            "TMDB_API_KEY",
            "\"$tmbApiKey\""
        )

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

}

configurations.all {
    exclude(group = "com.intellij", module = "annotations")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    /*********** Added dependencies *************/
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.serialization)

    implementation(libs.kotlinx.serialization.json)

    // Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // coil
    implementation(libs.coil.compose)
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.3.0")
}