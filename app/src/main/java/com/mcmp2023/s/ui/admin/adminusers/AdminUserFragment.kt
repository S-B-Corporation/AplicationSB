package com.mcmp2023.s.ui.admin.adminusers

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcmp2023.s.R
import com.mcmp2023.s.data.db.models.UserModel
import com.mcmp2023.s.databinding.FragmentAdminUserBinding
import com.mcmp2023.s.ui.admin.adminprofiles.viewmodel.AdminProfilesViewModel
import com.mcmp2023.s.ui.admin.adminusers.usersrecyclerview.UsersRecyclerViewAdapter
import com.mcmp2023.s.ui.admin.adminusers.viewmodel.AdminUserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AdminUserFragment : Fragment() {

    private lateinit var binding: FragmentAdminUserBinding
    private lateinit var adapter: UsersRecyclerViewAdapter

    private val userViewModel : AdminUserViewModel by activityViewModels {
        AdminUserViewModel.Factory
    }

    private val profileViewModel : AdminProfilesViewModel by activityViewModels {
        AdminProfilesViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

    }


    private fun setRecyclerView(view: View) {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = UsersRecyclerViewAdapter {
            showSelectedUser(it)
        }

        binding.usersRecyclerView.adapter = adapter
        displayUsers()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayUsers() {
        CoroutineScope(Dispatchers.Main).launch {
            adapter.setData(userViewModel.getUsers())
        }
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedUser(user: UserModel) {
        profileViewModel.setSelectedUser(user)
        findNavController().navigate(R.id.action_adminUserFragment_to_adminProfilesFragment)
    }


}