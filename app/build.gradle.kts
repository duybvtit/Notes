plugins {
    id("com.android.application")
    id("kotlin-parcelize")
    id("kotlin-kapt")
//    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("android")
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
        kotlinCompilerExtensionVersion = "1.2.0"
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

    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.AndroidX.coreKTX)

    // Integration with activities
    implementation(Deps.ComposeLibs.composeActivity)
    // Compose Material Design
    implementation(Deps.ComposeLibs.material)
    implementation(Deps.ComposeLibs.animation)
    implementation(Deps.ComposeLibs.tooling)
    implementation(Deps.ComposeLibs.toolingPreview)
    implementation(Deps.ComposeLibs.ui)
    // Integration with ViewModels
    implementation(Deps.ComposeLibs.viewModel)

    // Hilt
    implementation(Deps.Hilt.hilt)
    kapt(Deps.Hilt.kaptHilt)
    implementation(Deps.Hilt.hiltNavigationCompose)

    testImplementation(Deps.UnitTesting.testJUnit)
    androidTestImplementation(Deps.UnitTesting.extJUnit)
    androidTestImplementation(Deps.UnitTesting.espressoCore)
    androidTestImplementation(Deps.ComposeLibs.testing)
}