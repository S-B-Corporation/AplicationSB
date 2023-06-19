package com.mcmp2023.s.network.dto.logout

import com.google.gson.annotations.SerializedName

data class LogoutResponse(
    @SerializedName("message") val message: String
)