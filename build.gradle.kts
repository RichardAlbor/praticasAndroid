buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (
            "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    kotlin("plugin.serialization") version "1.9.0" apply false
    alias(libs.plugins.google.gms.google.services) apply false
}