package com.mcmp2023.s

import android.app.Application
import com.mcmp2023.s.data.products
import com.mcmp2023.s.repositoires.ProductRepository

class ProductApplication :  Application() {
    val productRepository : ProductRepository by lazy {
        ProductRepository(products)
    }
}