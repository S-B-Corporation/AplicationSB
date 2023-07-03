package com.mcmp2023.s.network.dto.product


import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName
import com.mcmp2023.s.data.db.models.Category
import com.mcmp2023.s.data.db.models.Product

data class  ProductsByCategoriesResponse(
     @SerializedName("categoria") val category : Category,
     @SerializedName("productos") val products : List<Product>
)