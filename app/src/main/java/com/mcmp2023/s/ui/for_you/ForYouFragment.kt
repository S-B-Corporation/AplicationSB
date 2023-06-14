package com.mcmp2023.s.ui.for_you

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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


        navigation()

    }

    private fun navigation() {

        val navHost = childFragmentManager.findFragmentById(R.id.for_you_nav_host) as NavHostFragment
        val navController = navHost.navController


        //Go to SellProductFragment
        binding.sellTextView.setOnClickListener {
            findNavController().navigate(R.id.action_forYouFragment_to_sellProductFragment)

        }

        binding.forYouTextView.setOnClickListener {

            val currentDestination =  navController.currentDestination
            val currentDestinationId = currentDestination?.id

            if (currentDestinationId != R.id.productRecyclerViewFragment) {
                navController.navigate(R.id.action_categoriesFragment_to_productRecyclerViewFragment)
            }
        }

        binding.categoryTextView.setOnClickListener {

            val currentDestination =  navController.currentDestination
            val currentDestinationId = currentDestination?.id

            if (currentDestinationId != R.id.categoriesFragment) {
                navController.navigate(R.id.action_productRecyclerViewFragment_to_categoriesFragment)
            }
        }

        binding.userImageView.setOnClickListener {
            findNavController().navigate(R.id.action_forYouFragment_to_profileFragment)

        }

    }

}