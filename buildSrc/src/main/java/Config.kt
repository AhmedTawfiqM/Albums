object Config {

    val baseUrl = BaseUrl

    object BaseUrl {
        //TODO: move urls to gradle.properties
        const val production = "https://jsonplaceholder.typicode.com/"
        const val develop = "https://jsonplaceholder.typicode.com/"
        const val staging = "https://jsonplaceholder.typicode.com/"
    }
}