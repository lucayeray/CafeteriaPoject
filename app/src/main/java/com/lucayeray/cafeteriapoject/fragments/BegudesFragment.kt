package com.lucayeray.cafeteriapoject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucayeray.cafeteriapoject.ProducteProvider
import com.lucayeray.cafeteriapoject.R
import com.lucayeray.cafeteriapoject.adapter.ProducteAdapter
import com.lucayeray.cafeteriapoject.databinding.FragmentMenjarsBinding
import com.lucayeray.cafeteriapoject.viewModel.BegudesViewModel
import com.lucayeray.cafeteriapoject.viewModel.SharedViewModel
import kotlin.getValue


class BegudesFragment : Fragment() {


    private lateinit var binding: FragmentMenjarsBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val begudesViewModel: BegudesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMenjarsBinding.inflate(inflater, container, false)

        binding.recyclerViewMenjars.layoutManager = LinearLayoutManager(requireContext())

        begudesViewModel.begudes.observe(viewLifecycleOwner) { llistaBegudes ->
            val adapter = ProducteAdapter(llistaBegudes) { producte ->
                sharedViewModel.afegirProducte(producte)
            }
            binding.recyclerViewMenjars.adapter = adapter
        }

        begudesViewModel.carregarBegudes(requireContext())

        return binding.root
    }

}