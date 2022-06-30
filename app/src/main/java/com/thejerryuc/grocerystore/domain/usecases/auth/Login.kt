package com.thejerryuc.grocerystore.domain.usecases.auth

import android.util.Log
import com.thejerryuc.grocerystore.data.remote.request.LoginRequest
import com.thejerryuc.grocerystore.data.remote.response.LoginResponse
import com.thejerryuc.grocerystore.domain.repositories.UserRepo
import com.thejerryuc.grocerystore.general.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class Login(private val userRepo: UserRepo) {

    operator fun invoke(request: LoginRequest): Flow<Resource<LoginResponse>> =
        flow {
            try {
                emit(Resource.Loading<LoginResponse>())
                var response = userRepo.login(request)
                emit(Resource.Success<LoginResponse>(response))
            } catch (e: HttpException){

                emit(Resource.Error<LoginResponse>(message = e.localizedMessage ?: "Something went wrong"))

            } catch (e: IOException){

                emit(Resource.Error<LoginResponse>(
                    message = e.localizedMessage
                        ?: ("Could not reach server, " + "please check your internet")

                ))
            } catch (e: Exception){

                emit(Resource.Error<LoginResponse>(
                    message = e.localizedMessage ?: "Something went wrong"
                ))

            }
        }
}