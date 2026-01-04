package com.lucayeray.cafeteriapoject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.model.Producte

class SharedViewModel : ViewModel() {

    private val _productesSeleccionats = MutableLiveData<MutableList<Producte>>(mutableListOf())

    private val _total = MutableLiveData<Double>(0.0)

    //Lista pública observable
    val productesSeleccionats: LiveData<MutableList<Producte>> = _productesSeleccionats

    //Total público observable
    val total: LiveData<Double> = _total

    //Añadir producto al carrito

    fun afegirProducte(producte: Producte) {
        _productesSeleccionats.value?.add(producte)
        _productesSeleccionats.value = _productesSeleccionats.value
        calcularTotal()
    }

    // 🔹 Vaciar carrito
    fun buidarCarret() {
        _productesSeleccionats.value?.clear()
        _productesSeleccionats.value = _productesSeleccionats.value
        _total.value = 0.0
    }

    // 🔹 Calcular total
    private fun calcularTotal() {
        _total.value = _productesSeleccionats.value?.sumOf { it.preu } ?: 0.0
    }

}