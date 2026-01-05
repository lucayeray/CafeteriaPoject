package com.lucayeray.cafeteriapoject.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comanda_table")
data class ComandaEntity(

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "total")
    val total: Double

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
