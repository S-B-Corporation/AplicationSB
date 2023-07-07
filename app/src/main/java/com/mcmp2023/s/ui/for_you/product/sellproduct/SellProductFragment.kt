package com.mcmp2023.s.ui.for_you.product.sellproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.R
import com.mcmp2023.s.data.db.models.Category
import com.mcmp2023.s.databinding.FragmentSellProductBinding
import com.mcmp2023.s.ui.for_you.categories.viewmodel.CategoriesViewModel
import com.mcmp2023.s.ui.for_you.product.sellproduct.viewmodel.SellProductViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SellProductFragment : Fragment() {

    private lateinit var spinner: Spinner

    private lateinit var binding: FragmentSellProductBinding

    private val categoryViewModel : CategoriesViewModel by activityViewModels {
        CategoriesViewModel.Factory
    }

    private val sellProductViewmodel: SellProductViewmodel by activityViewModels {
        SellProductViewmodel.Factory
    }

    val app by lazy {
        requireActivity().application as ProductApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSellProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sellProductViewmodel.token.value = app.getToken()

        //spinner
        CoroutineScope(Dispatchers.Main).launch {
            getCategoryAndLaunchSpinner()
        }

        //viewmodel
        setViewModel()

        //status
        observeStatus()
    }



    private fun setViewModel() {
        binding.viewmodel = sellProductViewmodel
    }

    private fun observeStatus(){
        sellProductViewmodel.status.observe(viewLifecycleOwner){status ->
            handleUiStatus(status)
        }
    }

    private fun handleUiStatus(status: SellProductUiStatus) { //different login status
        when (status) {
            //case error show An error has occurred
            is SellProductUiStatus.Error -> {
                Toast.makeText(requireContext(), "An error has occurred", Toast.LENGTH_SHORT).show()
            }
            //case errorWithMessage show status message
            is SellProductUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }
            //case success clear status and data the save token and pass to foryoufragment
            is SellProductUiStatus.Success -> {
                sellProductViewmodel.clearStatus()
                sellProductViewmodel.clearData()
                Toast.makeText(requireContext(), "Se ha publicado exitosamente su producto", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
            else -> {}
        }
    }


    private suspend fun getCategoryAndLaunchSpinner() {
        setCategorySpinner(categoryViewModel.getCategories())
    }

    private fun setCategorySpinner(categoryList: List<Category>){
        val categoryAdapter = ArrayAdapter(requireContext(), R.layout.spinner_item, categoryList.map { it.name })
        binding.categorySpinnerView.adapter = categoryAdapter

        binding.categorySpinnerView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCategory = categoryList[position]
                sellProductViewmodel.category.value = selectedCategory.name
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}