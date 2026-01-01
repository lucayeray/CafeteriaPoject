package com.lucayeray.cafeteriapoject

import android.content.Context
import com.lucayeray.cafeteriapoject.data.database.AppDatabase
import com.lucayeray.cafeteriapoject.data.model.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository {

    companion object {

        private var repositoryDatabase: AppDatabase? = null

        fun initializeDB(context: Context): AppDatabase {
            return AppDatabase.Companion.getDatabase(context)
        }

        fun insertUser(context: Context, user: UserEntity) {

            repositoryDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                repositoryDatabase!!.userDao().insertUser(user)
            }
        }
    }
}