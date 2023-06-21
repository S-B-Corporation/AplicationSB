package com.mcmp2023.s.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mcmp2023.s.data.db.dao.ProductDao
import com.mcmp2023.s.data.db.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductsDataBase : RoomDatabase() {
    abstract fun productDao() : ProductDao

    companion object {
        private var INSTANCE : ProductsDataBase? = null
        fun getInstance(application: Application): ProductsDataBase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application.applicationContext,
                    ProductsDataBase::class.java,
                    "product_app"
                )
                    .build()
                INSTANCE = instance
                instance
            }
    }
}