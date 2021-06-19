cmake_minimum_required(VERSION 3.22.1)

project(started-project-with-jni)

add_executable(
        example_executable
        executable/main.cpp
)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
add_library(
        # LIB_NAME_JNI_ON_LOAD parsing from build.gradle
        ${LIB_NAME_JNI_ON_LOAD}

        SHARED

        shared/example_jni_on_load/register.cpp
)

add_library(
        # LIB_NAME_NORMAL parsing from build.gradle
        ${LIB_NAME_NORMAL}

        SHARED

        shared/app.cpp
)

# This changes the filename to `shared.utils.so`
#set_target_properties(${LIB_NAME} PROPERTIES PREFIX "")

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.
find_library(
        # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log
)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.
target_link_libraries(
        ${LIB_NAME_JNI_ON_LOAD}
        ${LIB_NAME_NORMAL}
        ${log-lib}
)

add_compile_definitions(
        # API_KEY value parsing from build.gradle
        API_KEY="${API_KEY}"
)