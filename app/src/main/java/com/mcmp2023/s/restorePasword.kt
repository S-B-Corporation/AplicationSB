package com.mcmp2023.s

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mcmp2023.s.databinding.FragmentRestorePaswordBinding


class restorePasword : Fragment() {

    private lateinit var binding: FragmentRestorePaswordBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestorePaswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        binding.actionRestorePasswordBtn.setOnClickListener{
            validateData()
        }
         */

        binding.actionRestorePasswordBtn.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    private fun validateData() {
        val email = binding.TextFieldRestoreEmail.text.toString().trim()
        val codigo = binding.TextFieldCodeVerify.text.toString().trim()
        val newPassword = binding.TextFieldNewPass.text.toString().trim()
        val restorePassword = binding.TextFieldConfirmPass.text.toString().trim()

        if (email.isBlank()){
            binding.TextFieldRestoreEmail.error = "Este campo es obligatorio"
        }
        if (codigo.isBlank()){
            binding.TextFieldCodeVerify.error = "Este campo es obligatorio"
        }
        if (newPassword.isBlank()){
            binding.TextFieldNewPass.error = "Este campo es obligatorio"
        }
        if (restorePassword.isBlank()){
            binding.TextFieldConfirmPass.error = "Este campo es obligatorio"
        }
    }

}