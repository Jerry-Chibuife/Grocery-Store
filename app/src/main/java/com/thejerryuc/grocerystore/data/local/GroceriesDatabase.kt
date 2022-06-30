package com.thejerryuc.grocerystore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.thejerryuc.grocerystore.data.local.dao.GroceriesDAO
import com.thejerryuc.grocerystore.data.local.models.Grocery
import com.thejerryuc.grocerystore.data.local.typeconverter.ApplicationTypeConverter

@Database(
    entities = [
        Grocery::class
    ],
    version = 1
)
@TypeConverters(ApplicationTypeConverter::class)
abstract class GroceriesDatabase: RoomDatabase() {
    abstract val groceriesDAO: GroceriesDAO
    companion object {
        const val DATABASE_NAME = "groceries_store_db"
    }
}