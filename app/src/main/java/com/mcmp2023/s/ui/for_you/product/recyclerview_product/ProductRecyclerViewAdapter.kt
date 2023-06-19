package com.mcmp2023.s.ui.for_you.product.recyclerview_product

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.databinding.ProductItemBinding

class ProductRecyclerViewAdapter() : RecyclerView.Adapter<ProductRecyclerViewHolder>() {

    private val products = ArrayList<Product>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductRecyclerViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size ?: 0

    override fun onBindViewHolder(holder: ProductRecyclerViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    fun setData(productsList : List<Product>) {
        products.clear()
        products.addAll(productsList)

    }
}