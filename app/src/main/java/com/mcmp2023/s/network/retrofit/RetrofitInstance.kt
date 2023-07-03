package com.mcmp2023.s.network.retrofit

import com.mcmp2023.s.network.service.AuthService
import com.mcmp2023.s.network.service.ProductService
import com.mcmp2023.s.network.service.RestorePasswordService
import com.mcmp2023.s.network.service.UserService
import com.mcmp2023.s.repositoires.credentialsrepo.RestorePasswordRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

 const val BASE_URL = "https://sybapimarketplace.shop"
//const val BASE_URL = "https://apisb.onrender.com"

object RetrofitInstance {
    private var TOKEN = ""
    //private var ROLE = ""

    fun setToken(token: String){
        this.TOKEN = token
        //this.ROLE = role
    }



    //retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    fun getRestorePasswordService() : RestorePasswordService {
        return retrofit.create(RestorePasswordService::class.java)
    }

    fun getProductService() : ProductService {
        return retrofit.create(ProductService::class.java)
    }

    fun getUserService() : UserService {
        return retrofit.create(UserService::class.java)
    }

}