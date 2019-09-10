package com.guanhong.mvvmpractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.guanhong.mvvmpractice.response.player.DataItem

@Database(entities = [(DataItem::class)], version = 1, exportSchema = false)
abstract class DataItemDbHelper : RoomDatabase() {

    abstract fun getRoomDataItemDao(): DataItemDao

    companion object {
        @Volatile
        private var instance: DataItemDbHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            DataItemDbHelper::class.java, "data-item.db"
        ).build()
    }
}