#ifndef ANDROID_STARTED_PROJECT_WITH_JNI_TEST_H
#define ANDROID_STARTED_PROJECT_WITH_JNI_TEST_H

#include <iostream>

class Test {

public:
    int data = 1;

    ~Test() {
        std::cout << "object delete" << std::endl;
    }
};

#endif
