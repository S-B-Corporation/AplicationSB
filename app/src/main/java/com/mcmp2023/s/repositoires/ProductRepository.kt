package com.mcmp2023.s.repositoires

import com.mcmp2023.s.data.models.ProductModel

class ProductRepository(private val products: MutableList<ProductModel>) {
    fun getProducts() = products
    fun addProduct(newProduct: ProductModel) = products.add(newProduct)
}