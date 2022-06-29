package com.thejerryuc.grocerystore.data.remote

import com.thejerryuc.grocerystore.data.remote.request.LoginRequest
import com.thejerryuc.grocerystore.data.remote.request.SignUpRequest
import com.thejerryuc.grocerystore.data.remote.response.LoginResponse
import com.thejerryuc.grocerystore.data.remote.response.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest) : LoginResponse

    @POST("api/v1/auth/signup")
    suspend fun signup(request: SignUpRequest): SignUpResponse
}