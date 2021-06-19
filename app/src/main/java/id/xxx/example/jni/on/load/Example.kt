package id.xxx.example.jni.on.load

import id.xxx.started_project.BuildConfig

object Example {

    init {
        System.loadLibrary(BuildConfig.LIB_NAME_JNI_ON_LOAD)
    }

    @JvmStatic
    external fun test(): String

    @JvmStatic
    external fun getApiKey(): String
}