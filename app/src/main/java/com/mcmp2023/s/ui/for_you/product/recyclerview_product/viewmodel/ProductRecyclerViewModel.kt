package com.mcmp2023.s.ui.for_you.product.recyclerview_product.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.R
import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductRecyclerViewModel(private val productRepository: ProductRepository) : ViewModel() {

    val products = productRepository.getAll()

    private val _products = MutableLiveData<List<Product>>()
    val productsWhitCategory : LiveData<List<Product>> get() = _products
    val searchProduct : LiveData<List<Product>> get() = _products

    var error = MutableLiveData<Int?>(null)

    suspend fun getProducts() = productRepository.getProducts()
    fun getProductsByCategory(token: String, categoryName: String) {
       viewModelScope.launch {
           error.value = null
           try {
               if (categoryName.isNotBlank()) {
                   val response = productRepository.getProductsByCategories("Bearer $token", categoryName)
                   _products.value = response.products
                   Log.d("ViewModel", productsWhitCategory.toString())
               } else   {
                    error.value = R.string.error_empty_text
               }
           } catch (e: Exception) {
               Log.e("ViewModel", "Error al buscar", e)
           }
       }
    }

    fun searchProduct(name: String) {
        viewModelScope.launch {
            try {
                if (name.isNotBlank()) {
                    val response = productRepository.searchProduct(name)
                    _products.value = response
                    Log.d("ViewModel", productsWhitCategory.toString())
                } else   {
                    error.value = R.string.error_empty_text
                }
            } catch (e: Exception) {
                Log.e("ViewModel", "Error al buscar", e)
            }
        }
    }


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ProductApplication
                ProductRecyclerViewModel(app.productRepository)
            }
        }
    }

}