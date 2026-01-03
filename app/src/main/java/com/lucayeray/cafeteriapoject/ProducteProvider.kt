package com.lucayeray.cafeteriapoject

import com.lucayeray.cafeteriapoject.model.Producte

class ProducteProvider {

    companion object {

        fun getMenjars(): List<Producte> {
            return listOf(
                Producte("Hamburguesa", 8.50),
                Producte("Pizza", 9.00),
                Producte("Entrepà", 5.00)
            )
        }

        fun getBegudes(): List<Producte> {
            return listOf(
                Producte("Aigua", 1.50),
                Producte("Coca-Cola", 2.00)
            )
        }

        fun getPostres(): List<Producte> {
            return listOf(
                Producte("Gelat", 2.80),
                Producte("Pastís", 3.50)
            )
        }
    }

}