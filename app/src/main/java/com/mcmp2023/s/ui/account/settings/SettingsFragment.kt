package com.mcmp2023.s.ui.account.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    val app by lazy {
        requireActivity().application as ProductApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.settingBakArrowImageView.setOnClickListener {
            findNavController().popBackStack()
        }

        addListenners()
    }

    fun addListenners() {
        binding.actionLogout.setOnClickListener {
            app.saveAuthToken("")
            Toast.makeText(
                requireContext(),
                "Se ha cerrado sesion exitosamente",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_settingsFragment_to_fragmentLogin)
        }
    }


}