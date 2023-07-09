package com.mcmp2023.s.data.db.models

import com.google.gson.annotations.SerializedName

data class UserModel (
   @SerializedName("_id") val ID: String,
    val name: String,
    val email: String,
    val password: String,
    val productsID: IntArray
)