package com.lucayeray.cafeteriapoject.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producte_table")

data class ProducteEntity(

    @ColumnInfo(name = "nom")
    var nom: String,

    @ColumnInfo(name = "preu")
    var preu: Double,

    @ColumnInfo(name = "tipus")
    var tipus: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}