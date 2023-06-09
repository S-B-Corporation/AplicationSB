package com.mcmp2023.s.ui.account.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentLoginBinding


class fragmentLogin : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionLoginBtn.setOnClickListener{
            validateLogin()
        }

        binding.forgottPasswordTextView.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentLogin_to_restorePasword)
        }
    }

    private fun validateLogin() {
        val email = binding.TextFieldLoginEmail.text.toString().trim()
        val password = binding.TextFieldLoginPassword.text.toString().trim()

        if (email.isBlank()) {
            binding.TextFieldLoginEmail.error = "Este campo es necesario"
        }
        if (password.isBlank()) {
            binding.TextFieldLoginPassword.error = "Este campop es neceario"
        }
    }

}