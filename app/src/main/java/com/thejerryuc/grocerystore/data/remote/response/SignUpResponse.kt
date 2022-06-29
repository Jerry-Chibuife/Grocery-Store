package com.thejerryuc.grocerystore.data.remote.response

import com.thejerryuc.grocerystore.data.remote.models.User

data class SignUpResponse(
    val status:String,
    val token: String,
    val data: User
)
