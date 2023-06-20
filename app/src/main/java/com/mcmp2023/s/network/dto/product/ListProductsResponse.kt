package com.mcmp2023.s.network.dto.product


import com.mcmp2023.s.data.db.models.Product

data class ListProductsResponse(
     val results: List<Product>
)