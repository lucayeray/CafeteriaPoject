package com.lucayeray.cafeteriapoject.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lucayeray.cafeteriapoject.data.model.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: UserEntity)

    @Query("""
        SELECT * FROM user_table
        WHERE username = :username
        AND password = :password
        LIMIT 1
    """)
    fun login(username: String, password: String): LiveData<UserEntity?>


    @Query("SELECT * FROM user_table WHERE username = :username")
    fun encontrarUsuari(username: String): UserEntity?

}
