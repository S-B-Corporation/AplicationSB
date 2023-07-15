package com.mcmp2023.s.network.dto.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message") val message: String,
    @SerializedName("token") val token: String,
    @SerializedName("role") val role: String,
    @SerializedName("name") val name: String
)