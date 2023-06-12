package com.mcmp2023.s.network.dto.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("message") val message: String
)