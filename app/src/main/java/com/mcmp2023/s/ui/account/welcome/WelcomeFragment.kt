package com.mcmp2023.s.ui.account.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcmp2023.s.ProductApplication
import com.mcmp2023.s.R
import com.mcmp2023.s.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    val app by lazy {
        requireActivity().application as ProductApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setTokenOnView(){
        val tokenvalue = app.getToken()
        binding.tokenTextView.text = tokenvalue
    }


}