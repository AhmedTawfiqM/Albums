package deps

object TestLibs {

    val androidXLibs = AndroidXLibs

    const val junit = "junit:junit:${Versions.junit}"

    object AndroidXLibs {
        const val junit = "androidx.test.ext:junit:${Versions.junit_androidX}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    object Versions {
        const val junit = "4.+"
        const val junit_androidX = "1.1.3"
        const val espresso = "3.4.0"
    }
}