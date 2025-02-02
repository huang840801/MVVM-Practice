package com.guanhong.mvvmpractice.database

import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Delete

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: RoomEntity): Long

    @Query("SELECT * FROM room_entity")
    fun getAll(): List<RoomEntity>

    @Query("SELECT * FROM room_entity WHERE id LIKE :id")
    fun findById(id: Int): RoomEntity

    @Query("SELECT * FROM room_entity WHERE name LIKE :name")
    fun findByName(name: String): RoomEntity

    @Insert
    fun insertAll(item: RoomEntity)

    @Delete
    fun delete(item: RoomEntity)

    @Update
    fun update(item: RoomEntity)
}