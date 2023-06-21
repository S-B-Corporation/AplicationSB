package com.mcmp2023.s.data.db.models

data class UserModel (
    val ID: Int,
    val name: String,
    val email: String,
    val password: String,
    val productsID: IntArray
)