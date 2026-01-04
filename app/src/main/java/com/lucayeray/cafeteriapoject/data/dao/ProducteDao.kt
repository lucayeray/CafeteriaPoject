package com.lucayeray.cafeteriapoject.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity

@Dao
interface ProducteDao {

    @Insert
    fun insertProducte(producte: ProducteEntity)

    @Insert
    fun insertAll(productes: List<ProducteEntity>)

    @Query("SELECT * FROM producte_table")
    fun obtenirTots(): LiveData<List<ProducteEntity>>

    @Query("""
        SELECT * FROM producte_table
        WHERE tipus = :tipus
    """)
    fun obtenirPerTipus(tipus: String): LiveData<List<ProducteEntity>>

    @Query("DELETE FROM producte_table")
    fun esborrarTots()

}