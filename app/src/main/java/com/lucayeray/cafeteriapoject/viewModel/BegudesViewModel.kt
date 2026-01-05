package com.lucayeray.cafeteriapoject.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.ProducteRepository
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity

class BegudesViewModel : ViewModel() {
    private val _begudes = MutableLiveData<List<ProducteEntity>>()

    val begudes: LiveData<List<ProducteEntity>> = _begudes


    fun carregarBegudes(context: Context) {
        ProducteRepository
            .obtenirProductesPerTipus(context, "beguda")
            .observeForever { llista ->
                _begudes.value = llista
            }
    }

}