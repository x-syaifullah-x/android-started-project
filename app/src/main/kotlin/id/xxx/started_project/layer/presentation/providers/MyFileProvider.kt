package id.xxx.started_project.layer.presentation.providers

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import id.xxx.started_project.BuildConfig
import java.io.File

class MyFileProvider : FileProvider() {

    companion object {

        private const val APPLICATION_ID = BuildConfig.APPLICATION_ID
        private const val FILE_PROVIDER_AUTHORITIES = "$APPLICATION_ID.FILE_PROVIDER"

        fun getUriForFile(context: Context, file: File): Uri {
            return FileProvider.getUriForFile(
                context, FILE_PROVIDER_AUTHORITIES, file
            )
        }
    }
}