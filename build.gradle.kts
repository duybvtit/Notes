buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.kotlinGradle)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath(BuildPlugins.hiltPlugins)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

