#include <jni.h>
#include "../../utils/log.h"

#ifndef NATIVE_CPP
#define NATIVE_CPP

jstring test(JNIEnv *env, jclass clazz) {
    LOG_I("%s", "native methode test called");
    return env->NewStringUTF("TEST");
}

jstring getApiKey(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF(API_KEY);
}

#endif