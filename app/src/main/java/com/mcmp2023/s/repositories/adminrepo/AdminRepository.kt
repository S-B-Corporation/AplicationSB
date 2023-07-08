package com.mcmp2023.s.repositories.adminrepo

import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.data.db.models.UserModel
import com.mcmp2023.s.network.service.UserService

class AdminRepository (private val api: UserService) {
    suspend fun getUsers() : List<UserModel> {
        val response = api.getUsers()
        return response
    }

    suspend fun getProductsByUser(id: Int) : List<Product> {
        val response = api.getProducts(id)
        return response
    }
}