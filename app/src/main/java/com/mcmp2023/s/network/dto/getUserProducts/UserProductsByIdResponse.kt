package com.mcmp2023.s.network.dto.getUserProducts

import com.google.gson.annotations.SerializedName
import com.mcmp2023.s.data.db.models.Product

data class UserProductsByIdResponse(
    @SerializedName("productos") val products: List<Product>
)