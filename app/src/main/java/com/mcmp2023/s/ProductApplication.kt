package com.mcmp2023.s

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.mcmp2023.s.network.retrofit.RetrofitInstance
import com.mcmp2023.s.data.categories
import com.mcmp2023.s.data.db.ProductsDataBase
import com.mcmp2023.s.network.retrofit.RetrofitInstance.getProductService
import com.mcmp2023.s.repositories.CategoryRepository
import com.mcmp2023.s.repositories.ProductRepository
import com.mcmp2023.s.repositories.credentialsrepo.CredentialsRepository

class ProductApplication :  Application() {

    private val productService by lazy {
        getProductService()
    }

    private val database: ProductsDataBase by lazy {
        ProductsDataBase.getInstance(this)
    }

    val productRepository : ProductRepository by lazy {
        ProductRepository(productService, database)
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

    companion object {
        const val USER_TOKEN = "user_token"
    }

    val categoryRepository : CategoryRepository by lazy {
        CategoryRepository(categories)
    }
}