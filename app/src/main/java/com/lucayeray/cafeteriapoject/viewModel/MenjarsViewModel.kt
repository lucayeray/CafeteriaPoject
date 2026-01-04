package com.lucayeray.cafeteriapoject.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.ProducteProvider
import com.lucayeray.cafeteriapoject.ProducteRepository
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity
import com.lucayeray.cafeteriapoject.model.Producte

class MenjarsViewModel : ViewModel() {

    private val _menjars = MutableLiveData<List<ProducteEntity>>()

    val menjars: LiveData<List<ProducteEntity>> = _menjars

    fun carregarMenjars(context: Context) {
        ProducteRepository
            .obtenirProductesPerTipus(context, "menjar")
            .observeForever { llista ->
                _menjars.value = llista
            }
    }
}
