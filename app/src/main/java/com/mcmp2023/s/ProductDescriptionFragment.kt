package com.mcmp2023.s

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcmp2023.s.databinding.FragmentProductDescriptionBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProductDescriptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentProductDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

}