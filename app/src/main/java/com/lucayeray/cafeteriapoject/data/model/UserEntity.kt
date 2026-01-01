package com.lucayeray.cafeteriapoject.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "password")
    var password: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
