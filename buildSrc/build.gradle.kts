import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}


repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven(url = "https://www.jitpack.io")
    maven(
        url =("https://maven.google.com")
    )
}