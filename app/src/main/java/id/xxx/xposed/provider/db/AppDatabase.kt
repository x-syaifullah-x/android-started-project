package id.xxx.xposed.provider.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import id.xxx.xposed.provider.db.dao.ExampleDao
import id.xxx.xposed.provider.db.entity.ExampleEntity

@androidx.room.Database(
    entities = [
        ExampleEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(AppDatabase::class.java) {
                instance ?: Room
                    .databaseBuilder(context, AppDatabase::class.java, "database")
                    .allowMainThreadQueries()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                        }
                    }).build()
                    .also { database -> instance = database }
            }
    }


    abstract fun exampleDao(): ExampleDao
}