package com.mcmp2023.s

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.mcmp2023.s.network.retrofit.RetrofitInstance
import com.mcmp2023.s.data.categories
import com.mcmp2023.s.data.db.ProductsDataBase
import com.mcmp2023.s.network.retrofit.RetrofitInstance.getProductService
import com.mcmp2023.s.network.retrofit.RetrofitInstance.getRestorePasswordService
import com.mcmp2023.s.network.retrofit.RetrofitInstance.getUserService
import com.mcmp2023.s.repositoires.credentialsrepo.RestorePasswordRepository
import com.mcmp2023.s.repositories.CategoryRepository
import com.mcmp2023.s.repositories.ProductRepository
import com.mcmp2023.s.repositories.adminrepo.AdminRepository
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
    fun getUsername(): String = prefs.getString(USER_NAME, "")!!

    //fun getRole(): String = prefs.getString(USER_ROLE, "")!!

    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getApiService())
    }

    val restorePasswordRepository: RestorePasswordRepository by lazy {
        RestorePasswordRepository(restorePasswordService)
    }

    private val restorePasswordService by lazy {
        getRestorePasswordService()
    }

    private val userService by lazy {
        getUserService()
    }

    val userRepository: AdminRepository by lazy {
        AdminRepository(userService)
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun saveUserRole(role: String) {
        val editor = prefs.edit()
        editor.putString(USER_ROLE, role)
        editor.apply()
    }

    fun saveUserName(name: String){
        val editor = prefs.edit()
        editor.putString(USER_NAME, name)
        editor.apply()
    }


    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_ROLE = "user_role"
        const val USER_NAME = "user_name"
    }

    val categoryRepository : CategoryRepository by lazy {
        CategoryRepository(categories)
    }
}