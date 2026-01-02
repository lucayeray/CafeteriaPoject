package com.lucayeray.cafeteriapoject.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.data.model.UserEntity
import com.lucayeray.cafeteriapoject.UserRepository

class LoginViewModel : ViewModel() {

    private val _loginCorrecto = MutableLiveData<Boolean>()
    val loginCorrecto: LiveData<Boolean> = _loginCorrecto

    fun login(context: Context, username: String, password: String) {
        UserRepository.loginUser(context, username, password)
            .observeForever { user ->
                _loginCorrecto.value = (user != null)
            }
    }
}