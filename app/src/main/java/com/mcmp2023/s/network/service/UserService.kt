package com.mcmp2023.s.network.service

import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.data.db.models.UserModel
import com.mcmp2023.s.network.dto.deleteUsers.DeleteUserResponse
import com.mcmp2023.s.network.dto.getUserProducts.UserProductResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserService {
    @DELETE("/delete/usuarios/{id}")
    suspend fun deleteUser(
        @Header("Authorization") token: String,
        @Path("id") categoryName: String
    ) : DeleteUserResponse

    @GET("/getAllClientes")
    suspend fun getUsers(): List<UserModel>

    //obtener productos por medio del id del cliente

    @GET("/cliente/productos/{id}")
    suspend fun getProducts(): List<Product>

    @GET("/client/products")
    suspend fun getUserProduct(
        @Header("Authorization") token: String
    ): List<Product>
}