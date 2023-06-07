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
import com.google.android.material.textfield.TextInputLayout

class createAccount : Fragment() {

    private lateinit var nameTextInputLayout: EditText
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

        nameTextInputLayout = view.findViewById(R.id.NameTextField)
        emailTextInputLayout = view.findViewById(R.id.outlinedTextFieldEmail)
        passwordTextInputLayout = view.findViewById(R.id.outlinedTextFieldPassword)
        btnRegister = view.findViewById(R.id.registerButton)

        btnRegister.setOnClickListener {
            validate()
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.haveAccountTextView).setOnClickListener {
            findNavController().navigate(R.id.action_createAccount_to_fragmentLogin)
        }
    }

    private fun validate() {
        TODO("CHANGE THE WAY WE VALIDATE DE DATA")

    /*    val name = nameTextInputLayout.editText?.text.toString().trim()
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
        */

    }

}