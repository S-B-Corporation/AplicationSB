package com.mcmp2023.s.ui.for_you.product.recyclerview_product

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.mcmp2023.s.data.models.ProductModel
import com.mcmp2023.s.databinding.ProductItemBinding

class ProductRecyclerViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: ProductModel) {
        binding.cardProductName.text = product.tittle
        product.price.toString().also { binding.cardProductPrice.text = it }
    }
}