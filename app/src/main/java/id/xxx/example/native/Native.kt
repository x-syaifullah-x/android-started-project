package id.xxx.example.native

object Native {
    init {
        System.loadLibrary("example")
    }

    @JvmStatic
    external fun example(): String
}