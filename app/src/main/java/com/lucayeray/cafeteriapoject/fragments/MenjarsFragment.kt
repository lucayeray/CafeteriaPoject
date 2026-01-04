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
import com.lucayeray.cafeteriapoject.viewModel.MenjarsViewModel
import com.lucayeray.cafeteriapoject.viewModel.SharedViewModel

class MenjarsFragment : Fragment() {

    private lateinit var binding: FragmentMenjarsBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val menjarsViewModel: MenjarsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewBinding
        binding = FragmentMenjarsBinding.inflate(inflater, container, false)

        // LayoutManager
        binding.recyclerViewMenjars.layoutManager =
            LinearLayoutManager(requireContext())

        menjarsViewModel.menjars.observe(viewLifecycleOwner) { llistaMenjars ->

            val adapter = ProducteAdapter(llistaMenjars) { producte ->
                sharedViewModel.afegirProducte(producte)
            }

            binding.recyclerViewMenjars.adapter = adapter
        }

        menjarsViewModel.carregarMenjars(requireContext())

        return binding.root
    }

}