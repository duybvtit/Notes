plugins {
    id("com.android.application")
    id("kotlin-parcelize")
//    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage") android {
    namespace = "com.example.noteapp"
    compileSdk = (ConfigData.compileSDKVersion)

    defaultConfig {
        applicationId = "com.example.noteapp"
        minSdk = (ConfigData.minSDKVersion)
        targetSdk = (ConfigData.targetSDKVersion)
        versionCode = (ConfigData.versionCode)
        versionName = (ConfigData.versionName)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    lint {
        quiet = true
        abortOnError = false
        ignoreWarnings = true
        disable.add("InvalidPackage")    //Some libraries have issues with this.
        disable.add("OldTargetApi")
//        //Lint gives this warning but SDK 20 would be Android L Beta.
        disable.add("IconDensities")             //For testing purpose. ThTis is safe to remove.
        disable.add("IconMissingDensityFolder")  //For testing purpose. This is safe to remove.
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            multiDexEnabled = true
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            multiDexEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes.add("LICENSE.txt")
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/DEPENDENCIES")
            excludes.add("META-INF/ASL2.0")
            excludes.add("META-INF/NOTICE")
            excludes.add("META-INF/LICENSE")
            excludes.add("META-INF/rxjava.properties")
        }
    }
}

dependencies {
    implementation(project(":core"))
   
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.AndroidX.coreKTX)


    implementation(libs.bundles.compose)
    implementation(libs.composeViewModel)

    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    implementation(libs.hiltNavigation)


    testImplementation(libs.testJUnit)
    androidTestImplementation(libs.extJUnit)
    androidTestImplementation(libs.espressoCore)
    androidTestImplementation(libs.testing)
}