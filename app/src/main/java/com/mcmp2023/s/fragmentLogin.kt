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


class fragmentLogin : Fragment() {

    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var passwordTextInputLayout: TextInputLayout
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_login, container, false)

        emailTextInputLayout = view.findViewById(R.id.TextFieldLoginEmail)
        passwordTextInputLayout = view.findViewById(R.id.TextFieldLoginPassword)
        buttonLogin = view.findViewById(R.id.arrowbackwards)

        buttonLogin.setOnClickListener {
            validateLogin()
        }




        return view    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<TextView>(R.id.textView3).setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_restorePasword)
        }
    }

    private fun validateLogin() {
        val email = emailTextInputLayout.editText?.text.toString().trim()
        val password = passwordTextInputLayout.editText?.text.toString().trim()

        if (email.isBlank()) {
            emailTextInputLayout.error = "Este campo es necesario"
        }
        if (password.isBlank()) {
            passwordTextInputLayout.error = "Este campop es neceario"
        }
    }

}