package com.mcmp2023.s.network.retrofit

import com.mcmp2023.s.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "url"

class RetrofitInstance {
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
        return  retrofit.create(AuthService::class.java)
    }
}