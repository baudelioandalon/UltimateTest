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
//    compileSdk = AndroidConfig.compileSdk
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
            buildConfigField(
                type = "String",
                name = "BASE_URL",
                "\"https://rickandmortyapi.com/\""
            )

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = false
            isJniDebuggable = true
            buildConfigField(
                type = "String",
                name = "BASE_URL",
                "\"https://rickandmortyapi.com/\""
            )

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
//        compose = true
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    splits {
        abi {
            isEnable = true
            reset()
            include("x86", "armeabi-v7a")
            isUniversalApk = true
        }
    }
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
    annotationProcessor(libs.glide.compiler)

    //Lottie
    implementation(libs.lottie)

    implementation(libs.keyboard.visibility.event)

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

    //Dagger inyeccion de dependencias
//    implementation(Dependency.daggerHilt)
//    kapt(Dependency.daggerHiltCompiler)
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
}