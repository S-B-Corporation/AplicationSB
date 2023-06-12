package com.mcmp2023.s.network.service

import com.mcmp2023.s.network.dto.register.RegisterRequest
import com.mcmp2023.s.network.dto.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/auth/register")
    suspend fun register(@Body credentials: RegisterRequest): RegisterResponse
}