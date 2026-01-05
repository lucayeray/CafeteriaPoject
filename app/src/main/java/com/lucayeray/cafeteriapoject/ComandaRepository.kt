package com.lucayeray.cafeteriapoject

import android.content.Context
import androidx.lifecycle.LiveData
import com.lucayeray.cafeteriapoject.data.database.AppDatabase
import com.lucayeray.cafeteriapoject.data.model.ComandaEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComandaRepository {

    companion object {

        private var repositoryDatabase: AppDatabase? = null

        private fun initializeDB(context: Context): AppDatabase {
            return AppDatabase.getDatabase(context)
        }

        fun insertComanda(context: Context, comanda: ComandaEntity) {

            repositoryDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                repositoryDatabase!!
                    .comandaDao()
                    .insertComanda(comanda)
            }
        }

        fun obtenirComandesPerUsuari(
            context: Context,
            username: String
        ): LiveData<List<ComandaEntity>> {

            val database = AppDatabase.getDatabase(context)
            return database
                .comandaDao()
                .obtenirComandesPerUsuari(username)
        }
    }
}
