package com.mcmp2023.s.ui.admin.adminusers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.data.db.models.UserModel
import com.mcmp2023.s.repositories.UserRepository
import com.mcmp2023.s.repositories.adminrepo.AdminRepository

class AdminUserViewModel(private val adminRepository: AdminRepository) : ViewModel() {

    suspend fun getUsers() = adminRepository.getUsers()


    suspend fun deleteUser(token: String, id: String) = adminRepository.deleteUsers(token, id)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ProductApplication
                AdminUserViewModel(app.userRepository)
            }
        }
    }

}