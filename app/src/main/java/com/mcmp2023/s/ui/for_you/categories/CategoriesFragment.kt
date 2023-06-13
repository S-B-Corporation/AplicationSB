package com.mcmp2023.s.ui.for_you.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcmp2023.s.databinding.FragmentCategoriesBinding
import com.mcmp2023.s.ui.for_you.categories.recyclerview.CategoryRecyclerViewAdapter
import com.mcmp2023.s.ui.for_you.categories.viewmodel.CategoriesViewModel

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding

    private lateinit var adapter: CategoryRecyclerViewAdapter

    private val viewModel : CategoriesViewModel by activityViewModels {
        CategoriesViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter(view)
    }

    private fun setAdapter(view: View) {
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = CategoryRecyclerViewAdapter()

        binding.categoryRecyclerView.adapter = adapter
        displayCategories()

    }

    private fun displayCategories() {
        adapter.setData(viewModel.getCategories())
        adapter.notifyDataSetChanged()
    }
}
