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
    private lateinit var binding: FragmentCreateAccountBinding // Declaration of the data binding variable

    // Dependency injection to obtain a shared instance of the ViewModel
    private val registerViewModel: RegisterViewModel by activityViewModels {
        RegisterViewModel.Factory
    }

    //Getting the current application
    val app by lazy {
        requireActivity().application as ProductApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflating the view using databinding
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewmodel() //setting the viewmodel on the databinding
        setObserver() // Observing change in the login status

        //setting click listener to login fragment
        binding.registerButton.setOnClickListener {
            validate()
            findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
        }

        //case have account click listerner to login fragment
        binding.haveAccountTextView.setOnClickListener {
            findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
        }
    }

    //function to set viewmodel on the databinding
    private fun setViewmodel() {
        binding.viewmodel = registerViewModel
    }

    //function to observe changer on the register status
    private fun setObserver() {
        registerViewModel.status.observe(viewLifecycleOwner) { status ->
            handleUiStatus(status)
        }
    }

    private fun handleUiStatus(status: RegisterUiStatus) {
        when (status) {
            //case error show An error has ocurred
            is RegisterUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has ocurred", Toast.LENGTH_SHORT).show()
            }
            //case errorWithMessage show status messsage
            is RegisterUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            //case success clear status and data then go to login fragment
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

        if (name.isBlank()) {
            binding.nameTextField.error = "Este campo es obligatorio"
        }
        if (email.isBlank()) {
            binding.outlinedTextFieldEmail.error = "Este campo es obligatorio"
        }
        if (password.isBlank()) {
            binding.outlinedTextFieldPassword.error = "Este campo es obligatorio"
        }
    }

}