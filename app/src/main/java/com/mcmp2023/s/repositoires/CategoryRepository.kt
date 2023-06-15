package com.mcmp2023.s.repositoires

import com.mcmp2023.s.data.categories
import com.mcmp2023.s.data.models.Category

class CategoryRepository(private val category: MutableList<Category>) {

    fun getCategories() = categories

}