package com.mcmp2023.s.data

import com.mcmp2023.s.R
import com.mcmp2023.s.data.models.Category
import com.mcmp2023.s.data.models.ProductModel
import com.mcmp2023.s.data.models.UserModel


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

val username = "Juan"
val username2 = "Paco"

val usermID = 1
val usermID2 = 2

val userEmail = "Juna@gmail.com"
val userEmail2 = "Paco@gmail.com"

val userPassword = "232524233"
val userPassword2 = "232524233"

val arreglo: IntArray = intArrayOf(1, 2, 3, 4, 5)
val arreglo2: IntArray = intArrayOf(1, 2, 3, 4, 5)


val users = mutableListOf(
    UserModel(usermID, username, userEmail, userPassword, arreglo),
    UserModel(usermID2, username2, userEmail2, userPassword2, arreglo2)
)


var categoryName1 = "Vehiculos"
var categoryName2 = "Alquileres"
var categoryName3 = "Ropa y calzado de mujer"
var categoryName4 = "Ropa y calzado de hombre"
var categoryName5 = "Muebles"
var categoryName6 = "Electrónica"

var categoryIcon1 = R.drawable.car_icon
var categoryIcon2 = R.drawable.house_icon
var categoryIcon3 = R.drawable.dress_icon
var categoryIcon4 = R.drawable.tie_icon
var categoryIcon5 = R.drawable.lamp_icon
var categoryIcon6 = R.drawable.smartphone_icon


val categories = mutableListOf(
    Category(categoryName1, categoryIcon1),
    Category(categoryName2, categoryIcon2),
    Category(categoryName3, categoryIcon3),
    Category(categoryName4, categoryIcon4),
    Category(categoryName5, categoryIcon5),
    Category(categoryName6, categoryIcon6)
)