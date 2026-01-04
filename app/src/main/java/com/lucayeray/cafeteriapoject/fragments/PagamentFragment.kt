package com.lucayeray.cafeteriapoject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucayeray.cafeteriapoject.PagamentProvider
import com.lucayeray.cafeteriapoject.adapter.ProducteAdapter
import com.lucayeray.cafeteriapoject.databinding.FragmentPagamentBinding
import com.lucayeray.cafeteriapoject.viewModel.SharedViewModel
import kotlin.getValue

class PagamentFragment : Fragment() {

    private lateinit var binding: FragmentPagamentBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPagamentBinding.inflate(inflater, container, false)

        //RecyclerView
        binding.recyclerViewPagament.layoutManager =
            LinearLayoutManager(requireContext())


        sharedViewModel.productesSeleccionats.observe(viewLifecycleOwner) { llistaProductes ->

            val adapter = ProducteAdapter(llistaProductes) {}
            binding.recyclerViewPagament.adapter = adapter
        }

        sharedViewModel.total.observe(viewLifecycleOwner) { total ->
            binding.textTotal.text = "Total: %.2f €".format(total)
        }

        binding.btnPagar.setOnClickListener {
            sharedViewModel.buidarCarret()
        }

        return binding.root
    }
}
