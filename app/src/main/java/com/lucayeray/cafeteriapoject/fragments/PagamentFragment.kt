package com.lucayeray.cafeteriapoject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucayeray.cafeteriapoject.PagamentProvider
import com.lucayeray.cafeteriapoject.adapter.ProducteAdapter
import com.lucayeray.cafeteriapoject.databinding.FragmentPagamentBinding

class PagamentFragment : Fragment() {

    private lateinit var binding: FragmentPagamentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPagamentBinding.inflate(inflater, container, false)

        //RecyclerView
        binding.recyclerViewPagament.layoutManager =
            LinearLayoutManager(requireContext())
        val productes = PagamentProvider.obtenirProductes()

        val adapter = ProducteAdapter(productes)
        binding.recyclerViewPagament.adapter = adapter


        val total = PagamentProvider.calcularTotal()
        binding.textTotal.text = "Total: %.2f €".format(total)

        binding.btnPagar.setOnClickListener {
            PagamentProvider.buidarCarret()
            binding.recyclerViewPagament.adapter?.notifyDataSetChanged()
            binding.textTotal.text = "Total: 0.00 €"
        }

        return binding.root
    }
}
