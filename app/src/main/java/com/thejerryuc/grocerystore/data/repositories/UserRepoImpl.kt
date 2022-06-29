package com.thejerryuc.grocerystore.data.repositories

import com.thejerryuc.grocerystore.data.remote.Api
import com.thejerryuc.grocerystore.data.remote.request.LoginRequest
import com.thejerryuc.grocerystore.data.remote.request.SignUpRequest
import com.thejerryuc.grocerystore.data.remote.response.LoginResponse
import com.thejerryuc.grocerystore.data.remote.response.SignUpResponse
import com.thejerryuc.grocerystore.domain.repositories.UserRepo

class UserRepoImpl(private val api: Api) : UserRepo {
    override suspend fun login(request: LoginRequest): LoginResponse {
        return api.login(request)
    }

    override suspend fun signup(request: SignUpRequest): SignUpResponse {
        return api.signup(request)
    }
}