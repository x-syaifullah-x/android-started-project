#ifndef ANDROID_STARTED_PROJECT_WITH_JNI_LOG_CPP
#define ANDROID_STARTED_PROJECT_WITH_JNI_LOG_CPP

#include <android/log.h>

#define TAG "MY_APP"
#define LOG_I(...) ((void)__android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__))
#define LOG_W(...) ((void)__android_log_print(ANDROID_LOG_WARN, TAG, __VA_ARGS__))
#define LOG_E(...) ((void)__android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__))

#endif
