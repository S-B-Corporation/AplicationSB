package com.mcmp2023.s.ui.for_you.product.recyclerview_product

import androidx.recyclerview.widget.RecyclerView
import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.databinding.ProductItemBinding

class ProductRecyclerViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product) {
        binding.cardProductName.text = product.tittle
        product.price.toString().also { binding.cardProductPrice.text = it }
    }
}