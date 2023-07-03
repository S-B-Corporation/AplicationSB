package com.mcmp2023.s.network.dto.getUsers

import com.google.gson.annotations.SerializedName
import com.mcmp2023.s.data.db.models.UserModel

data class GetUsersResponse(
    @SerializedName("clientes") val clientes: List<UserModel>
)