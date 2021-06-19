package id.xxx.xposed.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import id.xxx.xposed.provider.db.AppDatabase
import id.xxx.xposed.provider.db.entity.ExampleEntity

class AppContentProvider : ContentProvider() {

    companion object {
        private const val ZERO = 1

        const val AUTHORITY = "id.xxx.xposed"
        private const val SCHEME = "content"

        val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
            .authority(AUTHORITY)
            .appendPath(ExampleEntity.TABLE_NAME)
            .build()
    }

    private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    private lateinit var database: AppDatabase

    init {
        sUriMatcher.addURI(
            AUTHORITY, ExampleEntity.TABLE_NAME, ZERO
        )
    }


    override fun onCreate(): Boolean {
        database = AppDatabase.getInstance(context ?: return false)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        TODO()
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO()
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

}