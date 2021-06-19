package id.xxx.example.constant

import id.xxx.started_project.BuildConfig

object AppBuild {

    const val IS_DEBUG = BuildConfig.BUILD_TYPE == "debug"

    const val APPLICATION_ID = BuildConfig.APPLICATION_ID

    const val AUTHORITY_FILE_PROVIDER = "${APPLICATION_ID}.FILE_PROVIDER"
}