package com.mcmp2023.s.network.service

import com.mcmp2023.s.network.dto.forgotPassword.ForgotPasswordRequest
import com.mcmp2023.s.network.dto.forgotPassword.ForgotPasswordResponse
import com.mcmp2023.s.network.dto.restorePassword.RestorePasswordRequest
import com.mcmp2023.s.network.dto.restorePassword.RestorePasswordResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RestorePasswordService {
    //forgot-password Service
    @POST("/forgot-password")
    suspend fun forgotPassword(@Body credentials: ForgotPasswordRequest) : ForgotPasswordResponse

    //restore password Service
    @POST("/restore-password")
    suspend fun restorePassword(@Body credentials: RestorePasswordRequest) : RestorePasswordResponse
}