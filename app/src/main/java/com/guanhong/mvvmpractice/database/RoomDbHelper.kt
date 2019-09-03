package com.guanhong.mvvmpractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.guanhong.mvvmpractice.database.RoomEntity.Companion.TABLE_NAME

@Database(entities = [(RoomEntity::class)], version = 2)
abstract class RoomDbHelper : RoomDatabase() {


    companion object {
        @Volatile private var instance: RoomDbHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            RoomDbHelper::class.java, "item-list.db")
            .addMigrations(MIGRATION_1_2)
            .build()


        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

                val tableName = TABLE_NAME
                database.execSQL("ALTER TABLE $tableName ADD COLUMN imageUrl TEXT NOT NULL DEFAULT ''")
            }
        }
    }

    abstract fun getRoomDao(): RoomDao
}