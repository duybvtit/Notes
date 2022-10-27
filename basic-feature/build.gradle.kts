import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import org.jetbrains.kotlin.kapt3.base.Kapt.kaptFlags

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage") android {
    namespace = "com.example.basic_feature"
    compileSdk = 32

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
    implementation(project(":core"))

    // Integration with activities
    implementation(Deps.ComposeLibs.composeActivity)
    // Compose Material Design
    implementation(Deps.ComposeLibs.material)
    implementation(Deps.ComposeLibs.animation)
    implementation(Deps.ComposeLibs.tooling)
    implementation(Deps.ComposeLibs.toolingPreview)
    implementation(Deps.ComposeLibs.ui)
    implementation(Deps.ComposeLibs.constraintLayout)
    // Integration with ViewModels
    implementation(Deps.ComposeLibs.viewModel)

    implementation(Deps.Hilt.hilt)
    kapt(Deps.Hilt.kaptHilt)
    implementation(Deps.Hilt.hiltNavigationCompose)


    testImplementation(Deps.UnitTesting.testJUnit)
    androidTestImplementation(Deps.UnitTesting.extJUnit)
    androidTestImplementation(Deps.UnitTesting.espressoCore)
    androidTestImplementation(Deps.ComposeLibs.testing)
}