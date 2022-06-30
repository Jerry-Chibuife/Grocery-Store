package com.thejerryuc.grocerystore.data.repositories

import com.thejerryuc.grocerystore.data.local.dao.GroceriesDAO
import com.thejerryuc.grocerystore.data.local.models.Grocery
import com.thejerryuc.grocerystore.domain.repositories.GroceryRepo
import kotlinx.coroutines.flow.Flow

class GroceryRepoImpl(private val groceriesDAO: GroceriesDAO) : GroceryRepo{

    override suspend fun saveProduct(grocery: Grocery) {
        groceriesDAO.saveGrocery(grocery)
    }

    override fun getAllProducts(): Flow<List<Grocery>> {
        return groceriesDAO.retrieveAllGroceries()
    }

}