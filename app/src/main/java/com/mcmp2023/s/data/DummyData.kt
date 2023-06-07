package com.mcmp2023.s.data

import com.mcmp2023.s.data.models.ProductModel


val id = 1
val title = "Cellphone"
val description = "En este lugar va la descripcion de tu producto"
val price = 23.53
val phoneNumber = "2328-6269"
val userID = 1

//Second Product
val id2 = 2
val tittle2 = "iphone 14"
val description2 = "En este lugar va la descripcion del producto iphone14"
val price2 = 24.56
val phoneNumber2 = "6968-7185"
val userId2 = 2

val products = mutableListOf(
    ProductModel(id, title, description, price, phoneNumber, userID),
    ProductModel(id2, tittle2, description2, price2, phoneNumber2, userId2)
)