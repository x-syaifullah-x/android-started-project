#include <jni.h>
#include <android/log.h>

extern "C" jstring
Java_id_xxx_example_native_Native_example(JNIEnv *env, jclass _) {
    __android_log_print(
            ANDROID_LOG_VERBOSE,
            "LOG FROM NATIVE JNI",
            "%s", "Java_id_xxx_example_native_Native_example() called"
    );
    return env->NewStringUTF("example");
}