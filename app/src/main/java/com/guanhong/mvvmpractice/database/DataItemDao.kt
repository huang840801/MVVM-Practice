package com.guanhong.mvvmpractice.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.guanhong.mvvmpractice.response.player.DataItem

@Dao
interface DataItemDao {

    @Query("SELECT * FROM DATA_ITEM_ENTITY")
    fun getAllDataItem(): DataSource.Factory<Int, DataItem>

    @Query("SELECT * FROM DATA_ITEM_ENTITY")
    fun getAll(): List<DataItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: DataItem): Long
}