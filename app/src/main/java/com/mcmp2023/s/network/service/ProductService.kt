package com.mcmp2023.s.network.service

import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.network.dto.product.ListProductsResponse
import retrofit2.http.GET

interface ProductService {

    // get all products
    @GET("/allProducts")
    suspend fun getAllProducts() : List<Product>

}