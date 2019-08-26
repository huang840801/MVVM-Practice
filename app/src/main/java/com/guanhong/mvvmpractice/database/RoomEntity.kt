package com.guanhong.mvvmpractice.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "room_entity")
class RoomEntity {

    companion object {
        const val TABLE_NAME = "room_entity"
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var name: String = ""

    @NonNull
    @ColumnInfo(name = "timestamp", typeAffinity = ColumnInfo.TEXT)
    var time = ""

    @Ignore
    var ignoreText = ""
}