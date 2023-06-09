package com.mcmp2023.s

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory.EdgeDirection
import com.google.android.material.textfield.TextInputLayout
import com.mcmp2023.s.databinding.FragmentCreateAccountBinding

class createAccount : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener{
            validate()
        }

        binding.haveAccountTextView.setOnClickListener{
            findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
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