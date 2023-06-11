package com.mcmp2023.s.ui.for_you.product.recyclerview_product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentProductRecyclerViewBinding
import com.mcmp2023.s.ui.for_you.product.recyclerview_product.viewmodel.ProductRecyclerViewModel

class ProductRecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentProductRecyclerViewBinding

    private lateinit var adapter: ProductRecyclerViewAdapter

    private val viewModel : ProductRecyclerViewModel by activityViewModels {
        ProductRecyclerViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)
    }


    private fun setRecyclerView(view: View) {
        binding.productsRecyclerView.layoutManager = GridLayoutManager(view.context, 2)

        adapter = ProductRecyclerViewAdapter()

        binding.productsRecyclerView.adapter = adapter
        displayProducts()

    }

    private fun displayProducts() {
        adapter.setData(viewModel.getProducts())
        adapter.notifyDataSetChanged()
    }
}