package com.mcmp2023.s.ui.for_you.product.sellproduct.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.network.ApiResponse
import com.mcmp2023.s.network.dto.sellproduct.SellProductRequest
import com.mcmp2023.s.repositories.ProductRepository
import com.mcmp2023.s.ui.for_you.product.sellproduct.SellProductUiStatus
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class SellProductViewmodel(private val repository: ProductRepository) : ViewModel() {
    val title = MutableLiveData("")
    val description = MutableLiveData("")
    val price = MutableLiveData("")
    val category = MutableLiveData("")
    val phoneNumber = MutableLiveData("")
    val token = MutableLiveData("")

    private val _bitmapLiveData = MutableLiveData<Bitmap>()
    val bitmapLiveData: LiveData<Bitmap> = _bitmapLiveData

    fun setBitmap(bitmap: Bitmap){
        _bitmapLiveData.value = bitmap
    }

    private val _status = MutableLiveData<SellProductUiStatus>(SellProductUiStatus.Resume)

    val status: MutableLiveData<SellProductUiStatus>
        get() = _status

    private fun validatePrice(): Float {
        if (!price.value.isNullOrEmpty()) {
            val pricef = price.value!!.toFloat()
            return pricef
        } else {
            return 0f
        }
    }

    private fun sellproduct(token: String, productReq: SellProductRequest) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.sellProduct("Bearer $token", productReq)) {
                    is ApiResponse.Error -> SellProductUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> SellProductUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Success -> SellProductUiStatus.Success
                }
            )
        }
    }

    fun onSellproduct() {
        if (!validateData()) {
            _status.value = SellProductUiStatus.ErrorWithMessage("Wrong Data")
            return
        }



        val productToSell =
            SellProductRequest(
                title.value!!,
                description.value!!,
                validatePrice(),
                category.value!!,
                phoneNumber.value!!,
                !!
            )
        sellproduct(token.value.toString(), productToSell)
    }

    private fun validateData(): Boolean {
        when {
            title.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            phoneNumber.value.isNullOrEmpty() -> return false
            price.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        title.value = ""
        description.value = ""
        category.value = ""
        phoneNumber.value = ""
        price.value = ""
    }

    fun clearStatus() {
        _status.value = SellProductUiStatus.Resume
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ProductApplication
                SellProductViewmodel(app.productRepository)
            }
        }
    }

}