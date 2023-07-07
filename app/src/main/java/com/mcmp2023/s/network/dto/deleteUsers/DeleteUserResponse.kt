package com.mcmp2023.s.network.dto.deleteUsers

import com.google.gson.annotations.SerializedName

data class DeleteUserResponse(
    @SerializedName("message") val message: String
)