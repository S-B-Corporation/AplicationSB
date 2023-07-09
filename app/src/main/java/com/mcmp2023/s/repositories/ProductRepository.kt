package com.mcmp2023.s.repositories

import com.mcmp2023.s.data.db.ProductsDataBase
import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.network.ApiResponse
import com.mcmp2023.s.network.dto.sellproduct.SellProductRequest
import com.mcmp2023.s.network.dto.sellproduct.SellProductResponse
import com.mcmp2023.s.network.service.ProductService
import okhttp3.MultipartBody
import retrofit2.HttpException
import java.io.IOException

class ProductRepository(
    private val api: ProductService,
    private val productsDataBase: ProductsDataBase
) {
    private val productDao = productsDataBase.productDao()
    suspend fun getProducts(): List<Product> {
        val response = api.getAllProducts()
        productDao.insertAll(response)
        return response
    }

    suspend fun getProductsByCategories(token: String, categoryName: String) =
        api.getProductsByCategory(token, categoryName)

    suspend fun searchProduct(productName: String) = api.searchProduct(productName)

    suspend fun sellProduct(
        token: String, productToSell: SellProductRequest
    ): ApiResponse<String> {
        try {
            val response: SellProductResponse = api.sellProduct(token, productToSell)

            return ApiResponse.Success(response.message)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("wrong data")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    fun getAll() = productDao.findAll()

}