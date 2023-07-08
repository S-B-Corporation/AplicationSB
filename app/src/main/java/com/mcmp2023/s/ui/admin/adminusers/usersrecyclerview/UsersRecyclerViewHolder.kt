package com.mcmp2023.s.ui.admin.adminusers.usersrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.mcmp2023.s.data.db.models.UserModel
import com.mcmp2023.s.databinding.UserItemBinding

class UsersRecyclerViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(
        user: UserModel,
        clickListener: (UserModel) -> Unit
    ) {
        binding.titleTextView.text = user.name

        binding.modelCard.setOnClickListener{
            clickListener(user)
        }
    }

}