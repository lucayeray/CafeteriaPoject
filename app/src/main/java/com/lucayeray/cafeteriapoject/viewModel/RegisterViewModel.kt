package com.lucayeray.cafeteriapoject.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.UserRepository
import com.lucayeray.cafeteriapoject.data.model.UserEntity

class RegisterViewModel : ViewModel() {

    fun registerUser(context: Context, username: String, password: String) {

        val user = UserEntity(username, password)
        UserRepository.insertUser(context, user)
    }
}