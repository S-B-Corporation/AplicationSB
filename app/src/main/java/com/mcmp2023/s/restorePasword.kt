package com.mcmp2023.s

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout


class restorePasword : Fragment() {

    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var codigoTextInputLayout: TextInputLayout
    private lateinit var newPassTextInputLayout: TextInputLayout
    private lateinit var restorePassTextInputLayout: TextInputLayout
    private lateinit var buttonRestorePass: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restore_pasword, container, false)

        emailTextInputLayout = view.findViewById(R.id.TextFieldRestoreEmail)
        codigoTextInputLayout = view.findViewById(R.id.TextFieldCodeVerify)
        newPassTextInputLayout = view.findViewById(R.id.TextFieldNewPass)
        restorePassTextInputLayout = view.findViewById(R.id.TextFieldConfirmPass)
        buttonRestorePass = view.findViewById(R.id.arrowbackwards)

        buttonRestorePass.setOnClickListener {
            validateData()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.arrowbackwards).setOnClickListener {
            findNavController().navigate(R.id.action_restorePasword_to_fragmentLogin)
        }
    }

    private fun validateData() {
        val email = emailTextInputLayout.editText?.text.toString().trim()
        val codigo = codigoTextInputLayout.editText?.text.toString().trim()
        val newpass = newPassTextInputLayout.editText?.text.toString().trim()
        val restorepass = restorePassTextInputLayout.editText?.text.toString().trim()

        if (email.isBlank()){
            emailTextInputLayout.error = "Este campo es obligatorio"
        }
        if (codigo.isBlank()){
            codigoTextInputLayout.error = "Este campo es obligatorio"
        }
        if (newpass.isBlank()){
            newPassTextInputLayout.error = "Este campo es obligatorio"
        }
        if (restorepass.isBlank()){
            restorePassTextInputLayout.error = "Este campo es obligatorio"
        }
    }

}