package com.mcmp2023.s.network.service

import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.network.dto.product.ProductsByCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ProductService {

    // get all products
    @GET("/allProducts")
    suspend fun getAllProducts(): List<Product>

    @GET("/searchCategorias/{categoryName}")
    suspend fun getProductsByCategory(
        @Header("Authorization") token: String,
        @Path("categoryName") categoryName: String
    ): ProductsByCategoriesResponse

    @GET("/searchProducts/{productName}")
    suspend fun searchProduct(@Path("productName") productName: String): List<Product>
}