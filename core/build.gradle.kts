plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage") android {
    namespace = "com.example.core"
    compileSdk = (ConfigData.compileSDKVersion)

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    kotlinOptions {
        jvmTarget = "1.8"

        freeCompilerArgs = listOf(
            "-opt-in=kotlinx.coroutines.FlowPreview",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
        )
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    // Compose Material Design
    implementation(Deps.ComposeLibs.material)
    implementation(Deps.ComposeLibs.tooling)
    implementation(Deps.ComposeLibs.toolingPreview)
    implementation(Deps.ComposeLibs.systemUIController)
    implementation(Deps.ComposeLibs.constraintLayout)

    // SquareUp
    implementation(Deps.SquareRemote.converterGson)
    implementation(Deps.SquareRemote.okHttpLogging)
    implementation(Deps.SquareRemote.okHttpProfiler)

    implementation(Deps.Hilt.hilt)
    kapt(Deps.Hilt.kaptHilt)
    implementation(Deps.Hilt.hiltNavigationCompose)

    implementation(Deps.AndroidX.lifecycle)
}