package com.lucayeray.cafeteriapoject.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.data.model.UserEntity
import com.lucayeray.cafeteriapoject.UserRepository

class LoginViewModel : ViewModel() {

    fun login(
        context: Context,
        username: String,
        password: String
    ): LiveData<UserEntity?> {
        return UserRepository.loginUser(context, username, password)
    }
}
