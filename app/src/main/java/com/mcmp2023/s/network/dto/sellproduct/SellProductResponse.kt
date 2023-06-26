package com.mcmp2023.s.network.dto.sellproduct

import com.google.gson.annotations.SerializedName

data class SellProductResponse(
    @SerializedName("message") val message: String
)