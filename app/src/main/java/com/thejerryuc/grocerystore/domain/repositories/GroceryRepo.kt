package com.thejerryuc.grocerystore.domain.repositories

import com.thejerryuc.grocerystore.data.local.models.Grocery
import kotlinx.coroutines.flow.Flow

interface GroceryRepo {
    suspend fun saveProduct(grocery: Grocery)
    fun getAllProducts(): Flow<List<Grocery>>
}