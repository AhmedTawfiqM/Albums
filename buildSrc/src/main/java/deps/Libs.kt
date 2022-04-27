package deps

object Libs {

    val androidLibs = AndroidLibs
    val materialDesignLibs = MaterialDesignLibs
    val networkLibs = NetworkLibs
    val gsonLibs = GsonLibs
    val coroutinesLibs = CoroutinesLibs

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

    object CoroutinesLibs{
        //coroutines
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }
    }

    object Versions {

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

