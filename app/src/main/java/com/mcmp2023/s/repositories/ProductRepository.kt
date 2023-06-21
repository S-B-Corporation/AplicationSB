package com.mcmp2023.s.repositories

import com.mcmp2023.s.data.db.ProductsDataBase
import com.mcmp2023.s.network.dto.product.ListProductsResponse
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
    fun getAll() = productDao.findAll()

}