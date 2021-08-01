#include <jni.h>

extern "C" JNIEXPORT jstring JNICALL
Java_id_xxx_example_presentation_MainActivity_stringFromJNI2(JNIEnv *env, jobject) {
    return env->NewStringUTF("Hello from C++");
}