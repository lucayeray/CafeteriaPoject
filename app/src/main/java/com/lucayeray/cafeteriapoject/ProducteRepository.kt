package com.lucayeray.cafeteriapoject

import android.content.Context
import androidx.lifecycle.LiveData
import com.lucayeray.cafeteriapoject.data.database.AppDatabase
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProducteRepository {

    companion object {

        private var repositoryDatabase: AppDatabase? = null

        fun initializeDB(context: Context): AppDatabase {
            return AppDatabase.getDatabase(context)
        }

        fun insertProducte(context: Context, producte: ProducteEntity) {

            repositoryDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                repositoryDatabase!!.producteDao().insertProducte(producte)
            }
        }

        fun obtenirProductes(context: Context): LiveData<List<ProducteEntity>> {
            val database = AppDatabase.getDatabase(context)
            return database.producteDao().obtenirTots()
        }

        fun obtenirProductesPerTipus(
            context: Context,
            tipus: String
        ): LiveData<List<ProducteEntity>> {
            val database = AppDatabase.getDatabase(context)
            return database.producteDao().obtenirPerTipus(tipus)
        }
    }
}
