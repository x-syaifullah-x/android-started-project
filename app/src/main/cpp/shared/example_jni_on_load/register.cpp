#include <jni.h>
#include "methods.cpp"

int registerClass(JNIEnv *env) {
    jclass j_class = env->FindClass("id/xxx/example/jni/on/load/Example");
    if (j_class == nullptr) return JNI_ERR;

    static const JNINativeMethod methods[] = {
            {
                    "test",
                    "()Ljava/lang/String;",
                    reinterpret_cast<void *>(test)
            },
            {
                    "getApiKey",
                    "()Ljava/lang/String;",
                    reinterpret_cast<void *>(getApiKey)
            },
    };

    return env->RegisterNatives(
            j_class,
            methods,
            (sizeof(methods) / sizeof(JNINativeMethod))
    );
}

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    if (vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    int rc = registerClass(env);

    return (rc != JNI_OK) ? rc : JNI_VERSION_1_6;
}