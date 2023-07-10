package com.mcmp2023.s.repositories.adminrepo

import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.data.db.models.UserModel
import com.mcmp2023.s.network.ApiResponse
import com.mcmp2023.s.network.dto.getUserProducts.UserProductResponse
import com.mcmp2023.s.network.service.UserService
import retrofit2.HttpException
import java.io.IOException

class AdminRepository (private val api: UserService) {
    suspend fun getUsers() : List<UserModel> {
        val response = api.getUsers()
        return response
    }

    suspend fun getUserProducts(token: String) : ApiResponse<List<Product>> {
        try {
            val response: List<Product> = api.getUserProduct(token)

            return ApiResponse.Success(response)
        }
        catch (e: HttpException){
            if (e.code() == 400){
                return ApiResponse.ErrorWithMessage("wrong data")
            }
            return ApiResponse.Error(e)
        }
        catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }
}