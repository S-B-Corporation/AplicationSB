package com.mcmp2023.s.network.dto.sellproduct

import okhttp3.MultipartBody

data class SellProductRequest(
    val titulo: String,
    val descripcion: String,
    val precio: Float,
    val categoriaNombre: String,
    val numerodecontacto: String,
    val image: String
)