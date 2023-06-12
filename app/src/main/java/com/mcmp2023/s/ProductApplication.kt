package com.mcmp2023.s

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.mcmp2023.s.data.products
import com.mcmp2023.s.network.retrofit.RetrofitInstance
import com.mcmp2023.s.repositoires.ProductRepository
import com.mcmp2023.s.repositoires.credentialsrepo.CredentialsRepository

class ProductApplication :  Application() {

    val productRepository : ProductRepository by lazy {
        ProductRepository(products)
    }

    //Retrofit storage and retrieve data
    private val prefs: SharedPreferences by lazy{
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }

    private fun getApiService() = with(RetrofitInstance){
        setToken(getToken())
        getLoginService()
    }

    fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getApiService())
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object{
        const val USER_TOKEN = "user_token"
    }
}