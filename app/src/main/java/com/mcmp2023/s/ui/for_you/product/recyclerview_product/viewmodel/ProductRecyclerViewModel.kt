package com.mcmp2023.s.ui.for_you.product.recyclerview_product.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.repositories.ProductRepository

class ProductRecyclerViewModel(private val productRepository: ProductRepository) : ViewModel() {

    val products = productRepository.getAll()

    suspend fun getProducts() = productRepository.getProducts()



    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ProductApplication
                ProductRecyclerViewModel(app.productRepository)
            }
        }
    }

}