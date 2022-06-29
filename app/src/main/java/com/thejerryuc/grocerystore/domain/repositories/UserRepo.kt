package com.thejerryuc.grocerystore.domain.repositories

import com.thejerryuc.grocerystore.data.remote.request.LoginRequest
import com.thejerryuc.grocerystore.data.remote.request.SignUpRequest
import com.thejerryuc.grocerystore.data.remote.response.LoginResponse
import com.thejerryuc.grocerystore.data.remote.response.SignUpResponse

interface UserRepo {
    suspend fun login(request:LoginRequest) : LoginResponse
    suspend fun signup(request: SignUpRequest): SignUpResponse
}