plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}
apply {
    plugin(Dependency.pluginKotlinApp)
    plugin(Dependency.pluginKotlinKapt)
    plugin(Dependency.pluginKotlinParcelize)
}

android {
    compileSdk = AndroidConfig.compileSdk
    namespace = "com.boreal.ultimatetest.core"

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        testOptions.targetSdk = AndroidConfig.targetSdk
        multiDexEnabled = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        ndk {
            abiFilters.addAll(listOf("armeabi-v7a", "armeabi", "x86"))
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isJniDebuggable = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = false
            isJniDebuggable = true


            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
//    splits {
//        abi {
//            isEnable = true
//            reset()
//            include("x86", "armeabi-v7a")
//            isUniversalApk = true
//        }
//    }
}

dependencies {


    implementation(project(":library:uisystem"))
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.gson)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.fragment.ktx)

    implementation(libs.androidx.recyclerview)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.work.runtime)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.arch.lifecycle.extensions)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    implementation(libs.glide)
    implementation(libs.androidx.foundation.android)
    kapt(libs.glide.compiler)

    //Lottie
    implementation(libs.lottie)

    //Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //Compose
    implementation(libs.compose.activity)
    implementation(libs.compose.navigation)
    implementation(libs.compose.uitooling)
    implementation(libs.compose.ui.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.util)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.icons.extended)
    implementation(libs.compose.runtime.live.data)
    implementation(libs.compose.lifecycle.view.model)
    implementation(libs.compose.material3)
    implementation(libs.compose.material3.window)
    implementation(libs.compose.material3.adaptive.navigation.suite)
    implementation(libs.accompanist.drawablepainter)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.lottie.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)


    //Ktor & kotlin Serialization
    implementation("io.ktor:ktor-client-android:2.3.10")
    implementation("io.ktor:ktor-client-serialization:2.3.10")
    implementation(libs.kotlinx.serialization.json)
    implementation("io.ktor:ktor-client-logging-jvm:2.3.10")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.10")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.10")

    implementation(libs.koin.android)

    //Load Image From Url
    implementation(libs.coil.compose)

    //Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    implementation(libs.retrofit.adapter)
    implementation(libs.util.codex)


    //Reactive
    implementation(libs.reactivenetwork.rx2)
    implementation(libs.reactivewifi.rx2)
    implementation(libs.sqliteassethelper)
    implementation(libs.kotlinx.serialization.json)
}