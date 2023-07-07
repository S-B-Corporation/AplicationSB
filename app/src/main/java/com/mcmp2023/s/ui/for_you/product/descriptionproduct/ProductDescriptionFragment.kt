package com.mcmp2023.s.ui.for_you.product.descriptionproduct

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentProductDescriptionBinding
import com.mcmp2023.s.ui.for_you.product.descriptionproduct.viewmodel.DescriptionViewModel
import com.mcmp2023.s.ui.for_you.product.recyclerview_product.viewmodel.ProductRecyclerViewModel

class ProductDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentProductDescriptionBinding

    private val viewModel : DescriptionViewModel by activityViewModels()

    private val productViewModel : ProductRecyclerViewModel by activityViewModels {
        ProductRecyclerViewModel.Factory
    }

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
        redirectWhatsApp(viewModel.phoneNumber.toString())
        Log.d("PhoneNumber", viewModel.phoneNumber.toString())
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

    private fun redirectWhatsApp(phoneNumber: String) {
        Log.d("phonenumber", phoneNumber)
        binding.whatsappButton.setOnClickListener {
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }
   /*
    private fun Favorites() {
        val isFavorite = productViewModel.favoriteProduct.contains(product)
        if (isFavorite) {
            binding.descriptionFavImageView.setImageResource(R.drawable.baseline_bookmark)
        } else {
            binding.de.setImageResource(R.drawable.bookmark)
        }
    }


    */
}