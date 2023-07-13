package com.mcmp2023.s.network.service

import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.network.dto.product.ProductsByCategoriesResponse
import com.mcmp2023.s.network.dto.sellproduct.SellProductRequest
import com.mcmp2023.s.network.dto.sellproduct.SellProductResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
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

    @GET("/searchProducts/byname/{productName}")
    suspend fun searchProduct(@Path("productName") productName: String): List<Product>

    //publish product
    @Multipart
    @POST("/products/add")
    suspend fun sellProduct(
        @Header("Authorization") token: String,
        @Part image: MultipartBody.Part,
        @Part("titulo") titulo: RequestBody,
        @Part("descripcion") descripcion: RequestBody,
        @Part("precio") precio: RequestBody,
        @Part("categoriaNombre") categoriaNombre: RequestBody,
        @Part("numerodecontacto") numerodecontacto: RequestBody
    ): SellProductResponse
}