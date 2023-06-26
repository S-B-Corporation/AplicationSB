package com.mcmp2023.s.network.dto.sellproduct

import okhttp3.MultipartBody

data class SellProductRequest(
    val title: String,
    val description: String,
    val price: Float,
    val category: String,
    val phoneNumber: String,
    val image: MultipartBody.Part
)