package com.mcmp2023.s.network.retrofit

import com.mcmp2023.s.network.service.AuthService
import com.mcmp2023.s.network.service.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://sybapimarketplace.shop"
//const val BASE_URL = "https://apisb.onrender.com"

object RetrofitInstance {
    private var TOKEN = ""

    fun setToken(token: String){
        this.TOKEN = token
    }

    //retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    fun getProductService() : ProductService {
        return retrofit.create(ProductService::class.java)
    }

}