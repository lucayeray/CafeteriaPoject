package com.lucayeray.cafeteriapoject.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lucayeray.cafeteriapoject.data.model.ComandaEntity

@Dao
interface ComandaDao {

    @Insert
    fun insertComanda(comanda: ComandaEntity)

    @Query("""
        SELECT * FROM comanda_table
        WHERE username = :username
    """)
    fun obtenirComandesPerUsuari(username: String): LiveData<List<ComandaEntity>>
}
