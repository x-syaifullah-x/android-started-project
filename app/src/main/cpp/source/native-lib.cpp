#include <jni.h>
#include <string>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL
Java_id_xxx_example_presentation_MainActivity_stringFromJNI(JNIEnv *env, jobject) {
    std::string hello = "Hello from C++";

    __android_log_print(ANDROID_LOG_INFO, "TRACKERS", "%d", 100);

    return env->NewStringUTF(hello.c_str());
}