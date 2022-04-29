package deps

object Libs {

    val androidLibs = AndroidLibs
    val materialDesignLibs = MaterialDesignLibs
    val networkLibs = NetworkLibs
    val gsonLibs = GsonLibs
    val coroutinesLibs = CoroutinesLibs
    val daggerLibs = DaggerLibs
    val compose = ComposeLibs

    object AndroidLibs {
        const val core = "androidx.core:core-ktx:${Versions.appCompat}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    }

    object MaterialDesignLibs {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object NetworkLibs {
        const val retrofitRuntime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

        //okHttp
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    }

    object GsonLibs {
        const val gsonGoogle = "com.google.code.gson:gson:${Versions.gsonGoogle}"
    }

    object CoroutinesLibs {
        //coroutines
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object DaggerLibs {
        private const val version = "2.38.1"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"

        private const val lifecycleViewModelVersion = "1.0.0-alpha03"
        const val lifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$lifecycleViewModelVersion"
        const val lifecycleViewModelCompiler= "androidx.hilt:hilt-compiler:$lifecycleViewModelVersion"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    //TODO: move to seperated ViewModelLib
        const val lifecycleViewModelKtx= "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
        const val lifecycleViewModelCompose= "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
    }

    object ComposeLibs {
        const val version = "1.0.5"
        const val activity = "androidx.activity:activity-compose:1.4.0"
        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"

        private const val navVersion = "2.4.2"
        const val navigation = "androidx.navigation:navigation-compose:$navVersion"

        const val coil = "io.coil-kt:coil-compose:2.0.0-rc03"
    }
}

object Versions {
    //TODO: add to every specified object
    //android core
    const val core = "1.6.0"
    const val appCompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.0"

    //network
    const val retrofit = "2.9.0"
    const val loggingInterceptor = "4.9.1"
    const val okHttp = "4.9.1"
    const val gsonGoogle = "2.8.7"

    //Kotlin Coroutines
    const val coroutines = "1.5.0"

}

