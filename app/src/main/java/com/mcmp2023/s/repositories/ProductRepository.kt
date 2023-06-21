package com.mcmp2023.s.repositories

import com.mcmp2023.s.data.db.ProductsDataBase
import com.mcmp2023.s.network.dto.product.ProductsByCategoriesResponse
import com.mcmp2023.s.network.service.ProductService

class ProductRepository(
    private val api: ProductService,
    private val productsDataBase: ProductsDataBase
) {
    private val productDao = productsDataBase.productDao()
    suspend fun getProducts()  {
        val response  = api.getAllProducts()
        productDao.insertAll(response)

    }
    suspend fun getProductsByCategories(token : String, categoryName:String) = api.getProductsByCategory(token, categoryName)

    suspend fun searchProduct(productName: String) = api.searchProduct(productName)

    fun getAll() = productDao.findAll()

}