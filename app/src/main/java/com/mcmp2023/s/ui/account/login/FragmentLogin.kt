package com.mcmp2023.s.ui.account.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentLoginBinding
import com.mcmp2023.s.ui.account.login.viewmodel.LoginViewModel


class fragmentLogin : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    //viewmodel instance
    private val loginViewModel: LoginViewModel by activityViewModels {
        LoginViewModel.Factory
    }

    val app by lazy {
        requireActivity().application as ProductApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()

        binding.actionRegisterTextView.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentLogin_to_createAccount)
        }

        binding.forgottPasswordTextView.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentLogin_to_restorePasword)
        }
    }

    private fun setViewModel(){
        binding.viewmodel = loginViewModel
    }

    private fun observeStatus(){
        loginViewModel.status.observe(viewLifecycleOwner) { status ->
            handleUiStatus(status)
        }
    }

    private fun handleUiStatus(status: LoginUiStatus){
        when(status){
            is LoginUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has ocurred",Toast.LENGTH_SHORT).show()
            }
            is LoginUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            is LoginUiStatus.Success -> {
                loginViewModel.clearStatus()
                loginViewModel.clearData()
                app.saveAuthToken(status.token)
                findNavController().navigate(R.id.action_fragmentLogin_to_welcomeFragment)
            }
            else -> {}
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