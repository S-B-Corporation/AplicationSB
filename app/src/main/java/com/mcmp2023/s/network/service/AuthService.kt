package com.mcmp2023.s.network.service

import com.mcmp2023.s.network.dto.login.LoginRequest
import com.mcmp2023.s.network.dto.login.LoginResponse
import com.mcmp2023.s.network.dto.logout.LogoutResponse
import com.mcmp2023.s.network.dto.register.RegisterRequest
import com.mcmp2023.s.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    //Login
    @POST("api/auth/login")
    suspend fun login(@Body credentials: LoginRequest) : LoginResponse

    //Register
    @POST("api/auth/register")
    suspend fun register(@Body credentials: RegisterRequest): RegisterResponse

    //Logout
    @POST("api/auth/logout")
    suspend fun logout() : LogoutResponse
}