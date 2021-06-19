#include <iostream>
#include "Test.h"

int main() {
    Test *test = new Test();
    std::cout << test->data << std::endl;
    delete test;
    return 0;
}