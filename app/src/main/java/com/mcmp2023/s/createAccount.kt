package com.mcmp2023.s

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout

class createAccount : Fragment() {

    private lateinit var nameTextInputLayout: TextInputLayout
    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var passwordTextInputLayout: TextInputLayout
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_account, container, false)

        nameTextInputLayout = view.findViewById(R.id.outlinedTextFieldName)
        emailTextInputLayout = view.findViewById(R.id.outlinedTextFieldEmail)
        passwordTextInputLayout = view.findViewById(R.id.outlinedTextFieldPassword)
        btnRegister = view.findViewById(R.id.buttonregister)

        btnRegister.setOnClickListener {
            validate()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.yatienescuenta).setOnClickListener {
            findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
        }
    }

    private fun validate() {
        val name = nameTextInputLayout.editText?.text.toString().trim()
        val email = emailTextInputLayout.editText?.text.toString().trim()
        val password = passwordTextInputLayout.editText?.text.toString().trim()

        if (name.isBlank() ) {
            nameTextInputLayout.error = "Este campo es obligatorio"
        }
        if(email.isBlank()){
            emailTextInputLayout.error = "Este campo es obligatorio"
        }
        if(password.isBlank()){
            passwordTextInputLayout.error = "Este campo es obligatorio"
        }
    }

}