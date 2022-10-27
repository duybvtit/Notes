object BuildPlugins {
    val androidGradle by lazy { "com.android.tools.build:gradle:${Versions.androidGradle}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val googleServices by lazy { "com.google.gms:google-services:${Versions.googleServices}" }
    val firebaseCrashlytics by lazy { "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlyticsGradle}" }
    val prefPlugins by lazy { "com.google.firebase:perf-plugin:${Versions.firebasePrefPlugins}" }
    val mapsPlatformSecrets by lazy { "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.secretGradlePlugins}" }
    val hiltPlugins by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
}

object Deps {
    //core android setup
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val testCoreKTX by lazy { "androidx.test:core-ktx:${Versions.testCore}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val kotlinStdLibs by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}" }
    val kotlinCoroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}" }
    val kotlinCoroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}" }
    val sdp by lazy { "com.intuit.sdp:sdp-android:${Versions.sdp}" }
    val ssp by lazy { "com.intuit.ssp:ssp-android:${Versions.ssp}" }
    val eventBus by lazy { "org.greenrobot:eventbus:${Versions.eventBus}" }
    val branchIO by lazy { "io.branch.sdk.android:library:5.+" }
    val browser by lazy { "androidx.browser:browser:${Versions.browser}" }
    val zxing by lazy { "com.journeyapps:zxing-android-embedded:${Versions.zxing}" }
    val desugar by lazy { "com.android.tools:desugar_jdk_libs:${Versions.desugarJdkLibs}" }
    val dialogCore by lazy { "com.afollestad.material-dialogs:core:${Versions.materialDialog}" }
    val dialogInpus by lazy { "com.afollestad.material-dialogs:input:3.3.0" }
    val playCore by lazy { "com.google.android.play:core:${Versions.playCore}" }
    val exoPlayer by lazy { "com.google.android.exoplayer:exoplayer-core:${Versions.exoPlayer}" }
    val localBroadcastMamanager by lazy { "androidx.localbroadcastmanager:localbroadcastmanager:${Versions.localBroadcastManager}" }

    object GoogleMaps {
        val mapCompose by lazy { "com.google.maps.android:maps-compose:${Versions.googleMapCompose}" }
        val mapServices by lazy { "com.google.android.gms:play-services-maps:${Versions.playServicesMap}" }
    }

    object JavaX {
        val jsr250API by lazy { "javax.annotation:jsr250-api:${Versions.javaxAnnotations}" }
        val javaInject by lazy { "javax.inject:javax.inject:${Versions.javaxInject}" }
    }

    object AndroidX {
        val coreKTX by lazy { "androidx.core:core-ktx:${Versions.androidXCoreKTX}" }
        val cardView by lazy { "androidx.cardview:cardview:${Versions.cardView}" }
        val recyclerView by lazy { "androidx.recyclerview:recyclerview:${Versions.recyclerView}" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
        val annotation by lazy { "androidx.annotation:annotation:$${Versions.annotationVersion}" }
        val preferencesKTX by lazy { "androidx.preference:preference-ktx:${Versions.preferenceKtx}" }
        val swipeRefresh by lazy { "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}" }
        val lifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
        val lifecycleKTX by lazy { "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}" }
        val lifecycleCommon by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}" }
        val playCoreKTX by lazy { "com.google.android.play:core-ktx:${Versions.googleCoreKTX}" }
    }

    object Hilt {
        val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
        val kaptHilt by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
        val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }
    }

    object Firebase {
        val firebaseBOM by lazy { "com.google.firebase:firebase-bom:${Versions.firebaseBom}" }
        val auth by lazy { "com.google.firebase:firebase-auth-ktx" }
        val dynamicLink by lazy { "com.google.firebase:firebase-dynamic-links-ktx" }
        val analytics by lazy { "com.google.firebase:firebase-analytics-ktx" }
        val crashlytics by lazy { "com.google.firebase:firebase-crashlytics-ktx" }
        val firestore by lazy { "com.google.firebase:firebase-firestore" }
        val iid by lazy { "com.google.firebase:firebase-iid" }
        val storage by lazy { "com.google.firebase:firebase-storage-ktx" }
        val authServices by lazy { "com.google.android.gms:play-services-auth:20.0.1" }
        val messaging by lazy { "com.google.firebase:firebase-messaging-ktx" }
        val adsIdentifier by lazy { "com.google.android.gms:play-services-ads-identifier:${Versions.playServicesAdsIdentifier}" }
        val servicesLocation by lazy { "com.google.android.gms:play-services-location:${Versions.playServicesLocation}" }
    }

    object Facebook {
        val login by lazy { "com.facebook.android:facebook-login:${Versions.facebookSDK}" }
        val sharing by lazy { "com.facebook.android:facebook-share:${Versions.facebookSDK}" }
    }

    object SquareRemote {
        val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
        val okHttpLogging by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingInterceptor}" }
        val adapterRxJava2 by lazy { "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitRxJava2}" }
        val rxJava2 by lazy { "io.reactivex.rxjava2:rxjava:${Versions.rxJava}" }
        val rxJavaAndroid by lazy { "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}" }
        val okHttpProfiler by lazy { "com.localebro:okhttpprofiler:${Versions.okhttpProfiler}" }
    }

    object ImageProcessor {
        val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
        val imagePicker by lazy { "com.github.dhaval2404:imagepicker-support:${Versions.imagePicker}" }
        val circleImage by lazy { "de.hdodenhof:circleimageview:3.0.1" }
        val glideCompose by lazy { "com.github.skydoves:landscapist-glide:${Versions.glideCompose}" }
        val coilCompose by lazy { "io.coil-kt:coil-compose:${Versions.coilCompose}" }
        val lottie by lazy { "com.airbnb.android:lottie:${Versions.lottie}" }
    }

    object Room {
        val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
        val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.room}" }
        val roomKTX by lazy { "androidx.room:room-ktx:${Versions.room}" }
        val roomKaptCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
    }

    object ComposeLibs {
        val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
        val material by lazy { "androidx.compose.material:material:${Versions.compose}" }
        val animation by lazy { "androidx.compose.animation:animation:${Versions.composeAnimation}" }
        val tooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeTooling}" }
        val toolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeTooling}" }
        val ui by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
        val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewModelCompose}" }
        val pager by lazy { "com.google.accompanist:accompanist-pager:${Versions.accompanist}" }
        val systemUIController by lazy { "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}" }
        val pagerIndicator by lazy { "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}" }
        val permissions by lazy { "com.google.accompanist:accompanist-permissions:${Versions.accompanist}" }
        val navigationAnimation by lazy { "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}" }
        val insets by lazy { "com.google.accompanist:accompanist-insets:${Versions.accompanist}" }
        val swipeRefresh by lazy { "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}" }
        val flowLayout by lazy { "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}" }
        val testing by lazy { "androidx.compose.ui:ui-test-junit4:1.1.1" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}" }
        val lottie by lazy { "com.airbnb.android:lottie-compose:${Versions.lottieCompose}" }
        val gestureDetecting by lazy { "com.github.SmartToolFactory:Compose-Extended-Gestures:${Versions.canvasGestureCompose}" }
    }

    object LocalTime {
        val localTime by lazy { "com.github.instacart.truetime-android:library-extension-rx:${Versions.trueTime}" }
    }

    object UnitTesting {
        val stdLib by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStdLib}" }
        val testJUnit by lazy { "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinTestJUnit}" }
        val roboletric by lazy { "org.robolectric:robolectric:${Versions.robolectric}" }
        val junit by lazy { "junit:junit:${Versions.jUnit}" }
        val mockitoKotlin by lazy { "com.nhaarman:mockito-kotlin:${Versions.mockito}" }
        val extJUnit by lazy { "androidx.test.ext:junit:${Versions.testJUnit}" }
        val testRules by lazy { "androidx.test:rules:${Versions.rule}" }
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
        val espressoIntent by lazy { "androidx.test.espresso:espresso-intents:${Versions.espresso}" }
        val annotation by lazy { "androidx.annotation:annotation:${Versions.annotationVersion}" }
        val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
        val kluent by lazy { "org.amshove.kluent:kluent-android:${Versions.kluent}" }
        val archCore by lazy { "androidx.arch.core:core-testing:${Versions.archCoreTesting}" }
        val kotlinCoroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test: ${Versions.kotlinCoroutinesTest}" }
    }
}