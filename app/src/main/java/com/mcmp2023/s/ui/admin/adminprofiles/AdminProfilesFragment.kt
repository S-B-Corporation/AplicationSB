package com.mcmp2023.s.ui.admin.adminprofiles

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mcmp2023.s.data.db.models.Product
import com.mcmp2023.s.databinding.FragmentAdminprofilesViewBinding
import com.mcmp2023.s.ui.admin.adminprofiles.profilerecyclerview.ProfileRecyclerViewAdapter
import com.mcmp2023.s.ui.admin.adminprofiles.viewmodel.AdminProfilesViewModel
import com.mcmp2023.s.ui.admin.adminusers.viewmodel.AdminUserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdminProfilesFragment : Fragment() {

    private lateinit var binding: FragmentAdminprofilesViewBinding

    private lateinit var adapter: ProfileRecyclerViewAdapter

    private val viewModel: AdminProfilesViewModel by activityViewModels {
        AdminProfilesViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminprofilesViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileNameTextView.text = viewModel.name
        setRecyclerView(view)

    }

    private fun setRecyclerView(view: View) {
        binding.profileRecyclerView.layoutManager = GridLayoutManager(view.context, 2)

        adapter = ProfileRecyclerViewAdapter {
            showSelectedProduct(it)
        }

        binding.profileRecyclerView.adapter = adapter
        displayProducts()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayProducts() {
        CoroutineScope(Dispatchers.Main).launch {
            adapter.setData(viewModel.getProductsByUser())
        }
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedProduct(product: Product) {
        viewModel.setSelectedProduct(product)
        findNavController()
    }

}