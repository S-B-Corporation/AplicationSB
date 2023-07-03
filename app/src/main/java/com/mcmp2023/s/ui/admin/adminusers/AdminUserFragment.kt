package com.mcmp2023.s.ui.admin.adminusers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentAdminUserBinding


class AdminUserFragment : Fragment() {

    private lateinit var binding: FragmentAdminUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminUserBinding.inflate(inflater, container, false)
        return binding.root
    }


}