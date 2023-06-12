package com.mcmp2023.s.ui.account.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcmp2023.s.network.ApiResponse
import com.mcmp2023.s.repositoires.credentialsrepo.CredentialsRepository
import com.mcmp2023.s.ui.account.login.LoginUiStatus
import kotlinx.coroutines.launch

class LoginViewModel (private val repository: CredentialsRepository) : ViewModel(){
    var email = MutableLiveData("")
    var password = MutableLiveData("")

    private val _status = MutableLiveData<LoginUiStatus>(LoginUiStatus.Resume)
    val status: MutableLiveData<LoginUiStatus>
        get() = _status

    private fun login(email: String, password: String){
        viewModelScope.launch {
            _status.postValue(
                when(val response = repository.login(email, password)){
                    is ApiResponse.Error -> LoginUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> LoginUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Succes -> LoginUiStatus.Success(response.data)
                }
            )
        }
    }

    fun onLogin() {
        if(!validat)
    }
}