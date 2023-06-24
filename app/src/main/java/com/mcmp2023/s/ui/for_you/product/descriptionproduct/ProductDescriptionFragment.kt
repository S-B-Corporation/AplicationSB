package com.mcmp2023.s.ui.for_you.product.descriptionproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentProductDescriptionBinding
import com.mcmp2023.s.ui.for_you.product.descriptionproduct.viewmodel.DescriptionViewModel

class ProductDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentProductDescriptionBinding

    private val viewModel : DescriptionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        renderImage(viewModel.imageUrl, view )
    }
    private fun setViewModel() {
        binding.viewmodel = viewModel
    }


    private fun renderImage(url: String, view: View) {
        val imageName = url.substringAfterLast("/")

        Glide
            .with(view)
            .load("https://sybapimarketplace.shop/uploads//${imageName}")
            .error(R.drawable.no_image_icon)
            .into(binding.productImage)
    }
}