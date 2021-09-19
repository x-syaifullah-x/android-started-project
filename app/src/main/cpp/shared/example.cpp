#include <jni.h>
#include <android/log.h>

extern "C" jstring
Java_id_xxx_example_native_Native_example(JNIEnv *env, jclass) {
    __android_log_print(ANDROID_LOG_INFO, "LOG FROM NATIVE JNI", "%s", "called");
    return env->NewStringUTF("example");
}