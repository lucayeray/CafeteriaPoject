package com.lucayeray.cafeteriapoject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lucayeray.cafeteriapoject.PagamentProvider
import com.lucayeray.cafeteriapoject.R
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity
import com.lucayeray.cafeteriapoject.model.Producte

class ProducteAdapter(
    private val llistaProductes: List<ProducteEntity>,
    private val onClick: (ProducteEntity) -> Unit
) : RecyclerView.Adapter<ProducteAdapter.ProducteViewHolder>() {

    class ProducteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.textNomProducte)
        val preu: TextView = view.findViewById(R.id.textPreuProducte)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProducteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_producte, parent, false)
        return ProducteViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProducteViewHolder, position: Int) {
        val producte = llistaProductes[position]

        holder.nom.text = producte.nom
        holder.preu.text = "${producte.preu} €"

        holder.itemView.setOnClickListener {
            onClick(producte)
        }
    }

    override fun getItemCount(): Int = llistaProductes.size
}
