package com.mcmp2023.s.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
/*
 * Product data
*/
@Entity(tableName = "products")
data class Product (
    // Product id
    @PrimaryKey @SerializedName("_id") val id : String,
    // Name of product
    @SerializedName("titulo")  val tittle: String,
    // Description of product
    @SerializedName("descripcion") val description: String,
    // Price of product
    @SerializedName("precio") val price: String,
    // User phone number
    @SerializedName("numerodecontacto") val phoneNumber: String,
    // User id
    @SerializedName("idcliente") val userID: String
)