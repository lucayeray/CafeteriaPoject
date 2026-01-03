package com.lucayeray.cafeteriapoject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucayeray.cafeteriapoject.ProducteProvider
import com.lucayeray.cafeteriapoject.R
import com.lucayeray.cafeteriapoject.adapter.ProducteAdapter
import com.lucayeray.cafeteriapoject.databinding.FragmentMenjarsBinding


class BegudesFragment : Fragment() {


    private lateinit var binding: FragmentMenjarsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewBinding
        binding = FragmentMenjarsBinding.inflate(inflater, container, false)

        //LayoutManager
        binding.recyclerViewMenjars.layoutManager = LinearLayoutManager(requireContext())

        //Datos desde el Provider
        val llistaMenjars = ProducteProvider.getBegudes()

        //Adapter
        val adapter = ProducteAdapter(llistaMenjars)

        //Asignar adapter al RecyclerView
        binding.recyclerViewMenjars.adapter = adapter

        return binding.root
    }

}