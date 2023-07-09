package com.mcmp2023.s.network.service

import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.data.db.models.UserModel
import com.mcmp2023.s.network.dto.deleteUsers.DeleteUserResponse
import com.mcmp2023.s.network.dto.getUserProducts.UserProductsByIdResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserService {
    @DELETE("/delete/users/{id}")
    suspend fun deleteUser(
        @Header("Authorization") token: String,
        @Path("id") categoryName: String
    ) : DeleteUserResponse

    @GET("/allClients")
    suspend fun getUsers(): List<UserModel>

    //obtener productos por medio del id del cliente

    @GET("/client/products/{id}")
    suspend fun getProducts(@Path("id") id : String): UserProductsByIdResponse

}