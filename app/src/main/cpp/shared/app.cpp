#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_id_xxx_example_App_test(JNIEnv *env, jobject app) {
    // API_KEY parsing from build.gradle
    return env->NewStringUTF(API_KEY);
}