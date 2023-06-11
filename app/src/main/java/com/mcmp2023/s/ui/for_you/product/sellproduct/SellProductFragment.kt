package com.mcmp2023.s.ui.for_you.product.sellproduct

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.mcmp2023.s.databinding.FragmentSellProductBinding


class SellProductFragment : Fragment() {

    private lateinit var spinner: Spinner

    private lateinit var binding: FragmentSellProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSellProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //find Spinner
        spinner = binding.categorySpinnerView
        val opciones = listOf("Opción 1", "Opción 2", "Opción 3")

        val adapter = ArrayAdapter(view.context, R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedOption = parent?.getItemAtPosition(position).toString()
                // Actions about Selected Options
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Actions in case nothing is selected
            }
        }

    }
}