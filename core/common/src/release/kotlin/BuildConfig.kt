object BuildConfig {
    const val isDebuggable: Boolean = false
    val variant: Variant = Variant.Release
    const val SOCKET_URL: String = "https://socket.exzi.com/"

}

enum class Variant{
    Debug,
    Release,
    Beta,
    BetaRelease
}