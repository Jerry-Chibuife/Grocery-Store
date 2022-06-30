package com.thejerryuc.grocerystore.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.thejerryuc.grocerystore.data.local.models.Grocery
import kotlinx.coroutines.flow.Flow

@Dao
interface GroceriesDAO {
    @Insert
    suspend fun saveGrocery(grocery: Grocery)

    @Delete
    suspend fun deleteGrocery(grocery: Grocery)

    @Query("select * from Grocery")
    fun retrieveAllGroceries(): Flow<List<Grocery>>

    @Query("select * from Grocery where id = :groceryId")
    fun retrieveAGrocery(groceryId: Int) : Grocery
}