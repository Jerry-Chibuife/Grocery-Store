package com.thejerryuc.grocerystore.data.remote.response

import com.thejerryuc.grocerystore.data.remote.models.User

data class LoginResponse(
    val status:String,
    val token: String,
    val data: User
)
