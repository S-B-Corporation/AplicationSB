package com.mcmp2023.s.network.dto.sellproduct

import okhttp3.MultipartBody

data class SellProductRequest(
    val titulo: String,
    val descripcion: String,
    val precio: Float,
    val categoria: String,
    val numerodecontacto: String,
    val image: String
)