package com.guanhong.mvvmpractice.database

import androidx.room.*

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: RoomEntity):Long

    @Query("SELECT * FROM room_entity")
    fun getAll(): List<RoomEntity>

    @Query("SELECT * FROM room_entity WHERE name LIKE :name")
    fun findByTitle(name: String): RoomEntity

    @Insert
    fun insertAll(vararg todo: RoomEntity)

    @Delete
    fun delete(todo: RoomEntity)

    @Update
    fun updateTodo(vararg todos: RoomEntity)
}