package com.mcmp2023.s.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mcmp2023.s.data.db.models.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<Product>)

    @Query("SELECT * FROM products")
    fun findAll(): LiveData<List<Product>>

}