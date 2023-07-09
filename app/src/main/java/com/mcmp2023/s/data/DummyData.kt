package com.mcmp2023.s.data

import com.mcmp2023.s.R
import com.mcmp2023.s.data.db.models.Category

var id1 = "1"


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
    Category(id1,categoryName1, categoryIcon1),
    Category(id1,categoryName2, categoryIcon2),
    Category(id1,categoryName3, categoryIcon3),
    Category(id1,categoryName4, categoryIcon4),
    Category(id1, categoryName5, categoryIcon5),
    Category(id1, categoryName6, categoryIcon6)
)