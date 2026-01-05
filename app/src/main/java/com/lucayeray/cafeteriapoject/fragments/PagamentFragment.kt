package com.lucayeray.cafeteriapoject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucayeray.cafeteriapoject.adapter.ProducteAdapter
import com.lucayeray.cafeteriapoject.databinding.FragmentPagamentBinding
import com.lucayeray.cafeteriapoject.viewModel.PagamentViewModel
import com.lucayeray.cafeteriapoject.viewModel.SharedViewModel
import kotlin.getValue

class PagamentFragment : Fragment() {

    private lateinit var binding: FragmentPagamentBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val pagamentViewModel: PagamentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPagamentBinding.inflate(inflater, container, false)

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

            val prefs = requireContext()
                .getSharedPreferences("cafeteria_prefs", android.content.Context.MODE_PRIVATE)

            val username = prefs.getString("username", null)

            if (username != null) {

                val total = sharedViewModel.total.value ?: 0.0

                pagamentViewModel.guardarComanda(
                    requireContext(),
                    username,
                    total
                )

                sharedViewModel.buidarCarret()
            }
        }

        return binding.root
    }
}
