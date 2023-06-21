package com.mcmp2023.s.network.dto.restorePassword

import com.google.gson.annotations.SerializedName

data class RestorePasswordResponse(
    @SerializedName("message") val message: String
)