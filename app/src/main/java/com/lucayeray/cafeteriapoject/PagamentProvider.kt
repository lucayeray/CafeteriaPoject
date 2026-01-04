package com.lucayeray.cafeteriapoject

import com.lucayeray.cafeteriapoject.model.Producte

object PagamentProvider {

    private val productesSeleccionats = mutableListOf<Producte>()

    fun afegirProducte(producte: Producte) {
        productesSeleccionats.add(producte)
    }

    fun obtenirProductes(): List<Producte> {
        return productesSeleccionats
    }

    fun calcularTotal(): Double {
        return productesSeleccionats.sumOf { it.preu }
    }

    fun buidarCarret() {
        productesSeleccionats.clear()
    }
}
