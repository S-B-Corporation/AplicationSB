package com.mcmp2023.s.network.dto.forgotPassword

import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse(
    @SerializedName("message") val message: String
)