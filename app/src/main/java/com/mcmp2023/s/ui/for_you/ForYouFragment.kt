package com.mcmp2023.s.ui.for_you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentForYouBinding

class ForYouFragment : Fragment() {

    //binding Instance
    private lateinit var binding: FragmentForYouBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForYouBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Go to SellProductFragment
        binding.sellTextView.setOnClickListener{
            findNavController().navigate(R.id.action_forYouFragment_to_sellProductFragment)
        }
    }


}