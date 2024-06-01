object BuildConfig {
    const val isDebuggable: Boolean = true
    val variant: Variant = Variant.Debug
    const val SOCKET_URL: String = "https://socket.exzi.com/"
    const val API_URL: String = "https://api.exzi.com/"

}

enum class Variant{
    Debug,
    Release,
    Beta,
    BetaRelease
}

enum class BaseUrl(val url: String){
    SOCKET(url = "https://socket.exzi.com/"),
    API(url = "https://api.exzi.com/")
}