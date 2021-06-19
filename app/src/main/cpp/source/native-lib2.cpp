#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_id_xxx_example_presentation_MainActivity_stringFromJNI2(JNIEnv *env, jobject) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}