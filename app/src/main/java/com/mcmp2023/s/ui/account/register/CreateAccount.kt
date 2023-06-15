package com.mcmp2023.s.ui.account.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentCreateAccountBinding
import com.mcmp2023.s.ui.account.register.viewmodel.RegisterViewModel

class createAccount : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding

    private val registerViewModel: RegisterViewModel by activityViewModels {
        RegisterViewModel.Factory
    }

    val app by lazy {
        requireActivity().application as ProductApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewmodel()
        setObserver()

        binding.registerButton.setOnClickListener{
            validate()
            findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
        }

        binding.haveAccountTextView.setOnClickListener{
            findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
        }
    }

    private fun setViewmodel() {
        binding.viewmodel = registerViewModel
    }

    private fun setObserver(){
        registerViewModel.status.observe(viewLifecycleOwner) {status ->
            handleUiStatus(status)
        }
    }

    private fun handleUiStatus(status: RegisterUiStatus) {
        when(status){
            is RegisterUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has ocurred", Toast.LENGTH_SHORT).show()
            }
            is RegisterUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            is RegisterUiStatus.Success -> {
                registerViewModel.clearStatus()
                registerViewModel.clearData()
                findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
                Log.d("APP REGISTERRR", "Succeeeeeeeeeeeeeeeees")
            }
            else -> {}
        }
    }

    private fun validate() {

        val name = binding.nameTextField.text.toString().trim()
        val email = binding.outlinedTextFieldEmail.text.toString().trim()
        val password = binding.outlinedTextFieldPassword.text.toString().trim()

        if (name.isBlank() ) {
            binding.nameTextField.error = "Este campo es obligatorio"
        }
        if(email.isBlank()){
            binding.outlinedTextFieldEmail.error = "Este campo es obligatorio"
        }
        if(password.isBlank()){
            binding.outlinedTextFieldPassword.error = "Este campo es obligatorio"
        }
    }

}