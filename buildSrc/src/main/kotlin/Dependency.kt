object Dependency {

    const val pluginKotlinApp = "kotlin-android"
    const val pluginKotlinKapt = "kotlin-kapt"
    const val pluginKotlinParcelize = "kotlin-parcelize"
    const val pluginSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val pluginBuildTools = "com.android.tools.build:gradle:${Version.buildToolsVersion}"
    const val pluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val pluginSageArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.safeArgsVersion}"
    const val pluginGmsGoogleServices =
        "com.google.gms:google-services:${Version.gmsGoogleServicesVersion}"
    //FIREBASE
    const val pluginFirebaseCrashlyticsGradle =
        "com.google.firebase:firebase-crashlytics-gradle:${Version.firebaseCrashlyticsGradle}"
}