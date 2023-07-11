package com.mcmp2023.s.network.dto.getUserProductsById

import com.google.gson.annotations.SerializedName
import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.data.db.models.UserModel

data class UserProductsByIdResponse(
    @SerializedName("cliente") val user: UserModel,
    @SerializedName("products") val products: List<Product>
)