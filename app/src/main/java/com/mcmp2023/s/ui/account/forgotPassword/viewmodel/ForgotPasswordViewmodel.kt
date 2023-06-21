package com.mcmp2023.s.ui.account.forgotPassword.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcmp2023.s.repositoires.credentialsrepo.RestorePasswordRepository

class ForgotPasswordViewmodel(private val repository: RestorePasswordRepository) : ViewModel(){
    var email = MutableLiveData("")

    private
}