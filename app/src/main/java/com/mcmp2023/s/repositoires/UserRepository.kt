package com.mcmp2023.s.repositoires

import com.mcmp2023.s.data.models.UserModel
import com.mcmp2023.s.data.userID

class UserRepository(private val users: MutableList<UserModel>) {
    fun getUsers() = users
    fun addUser(newUser: UserModel) = users.add(newUser)
}