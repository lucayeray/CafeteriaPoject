package com.lucayeray.cafeteriapoject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity

class SharedViewModel : ViewModel() {

    private val _productesSeleccionats = MutableLiveData<MutableList<ProducteEntity>>(mutableListOf())

    private val _total = MutableLiveData<Double>(0.0)

    val productesSeleccionats: LiveData<MutableList<ProducteEntity>> =
        _productesSeleccionats

    val total: LiveData<Double> = _total

    fun afegirProducte(producte: ProducteEntity) {
        _productesSeleccionats.value?.add(producte)
        _productesSeleccionats.value = _productesSeleccionats.value
        calcularTotal()
    }

    fun buidarCarret() {
        _productesSeleccionats.value?.clear()
        _productesSeleccionats.value = _productesSeleccionats.value
        _total.value = 0.0
    }

    private fun calcularTotal() {
        _total.value =
            _productesSeleccionats.value?.sumOf { it.preu } ?: 0.0
    }
}