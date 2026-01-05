package com.lucayeray.cafeteriapoject.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.ComandaRepository
import com.lucayeray.cafeteriapoject.data.model.ComandaEntity

class PagamentViewModel : ViewModel() {

    fun guardarComanda(
        context: Context,
        username: String,
        total: Double
    ) {
        val comanda = ComandaEntity(
            username = username,
            total = total
        )
        ComandaRepository.insertComanda(context, comanda)
    }
}