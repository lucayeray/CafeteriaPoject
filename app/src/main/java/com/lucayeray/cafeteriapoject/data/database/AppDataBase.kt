package com.lucayeray.cafeteriapoject.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lucayeray.cafeteriapoject.data.dao.ProducteDao
import com.lucayeray.cafeteriapoject.data.dao.UserDao
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity
import com.lucayeray.cafeteriapoject.data.model.UserEntity

import androidx.sqlite.db.SupportSQLiteDatabase
import com.lucayeray.cafeteriapoject.data.dao.ComandaDao
import com.lucayeray.cafeteriapoject.data.model.ComandaEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
    entities = [UserEntity::class, ProducteEntity::class, ComandaEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun producteDao(): ProducteDao

    abstract fun comandaDao(): ComandaDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "cafeteria_database"
            )
                .fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build()
        }

        private val roomCallback = object : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                // Se ejecuta SOLO la primera vez que se crea la BD
                CoroutineScope(Dispatchers.IO).launch {

                    val productesInicials = listOf(
                        ProducteEntity("Hamburguesa", 8.50, "menjar"),
                        ProducteEntity("Pizza", 9.00, "menjar"),
                        ProducteEntity("Entrepà", 5.00, "menjar"),
                        ProducteEntity("Sopa de la abuela", 100.00, "menjar"),

                        ProducteEntity("Aigua", 1.50, "beguda"),
                        ProducteEntity("Coca-Cola", 2.00, "beguda"),
                        ProducteEntity("Mejunje Raro", 50.00, "beguda"),

                        ProducteEntity("Gelat", 2.80, "postres"),
                        ProducteEntity("Pastís", 3.50, "postres"),
                        ProducteEntity("Coulant", 10.50, "postres")
                    )

                    INSTANCE?.producteDao()?.insertAll(productesInicials)
                }
            }
        }

    }


}
