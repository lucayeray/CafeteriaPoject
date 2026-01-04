package com.lucayeray.cafeteriapoject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucayeray.cafeteriapoject.ProducteProvider
import com.lucayeray.cafeteriapoject.R
import com.lucayeray.cafeteriapoject.adapter.ProducteAdapter
import com.lucayeray.cafeteriapoject.databinding.FragmentMenjarsBinding
import com.lucayeray.cafeteriapoject.viewModel.SharedViewModel
import kotlin.getValue

class PostresFragment : Fragment() {


    private lateinit var binding: FragmentMenjarsBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMenjarsBinding.inflate(inflater, container, false)

        binding.recyclerViewMenjars.layoutManager = LinearLayoutManager(requireContext())

        //Datos desde el Provider
        val llistaMenjars = ProducteProvider.getPostres()

        //Adapter
        val adapter = ProducteAdapter(llistaMenjars) { producte ->
            sharedViewModel.afegirProducte(producte)
        }

        //Asignar adapter al RecyclerView
        binding.recyclerViewMenjars.adapter = adapter

        return binding.root
    }
}