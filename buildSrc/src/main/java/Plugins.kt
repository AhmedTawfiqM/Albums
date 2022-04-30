object Plugins {

    val dagger = DaggerPlugins

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"

    const val kotlinAndroid = "kotlin-android"
    const val kotlinkapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"

    const val kotlinParcelize = "kotlin-parcelize"

    object DaggerPlugins {
        const val hilt = "dagger.hilt.android.plugin"
    }
}