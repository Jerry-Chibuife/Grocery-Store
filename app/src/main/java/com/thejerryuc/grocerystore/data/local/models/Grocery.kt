package com.thejerryuc.grocerystore.data.local.models

import androidx.room.*
import com.thejerryuc.grocerystore.data.local.typeconverter.ApplicationTypeConverter
import java.math.BigDecimal

@Entity
data class Grocery(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "grocery_image")
    val image: String,
    @ColumnInfo(name = "grocery_name")
    val name: String,
    @ColumnInfo(name = "grocery_desc")
    val description: String,
    @ColumnInfo(name = "grocery_price")
    @TypeConverters(ApplicationTypeConverter::class)
    val price: BigDecimal,
)
