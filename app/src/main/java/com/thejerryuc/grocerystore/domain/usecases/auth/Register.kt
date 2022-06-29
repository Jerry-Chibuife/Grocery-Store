package com.thejerryuc.grocerystore.domain.usecases.auth

import com.thejerryuc.grocerystore.data.remote.request.SignUpRequest
import com.thejerryuc.grocerystore.data.remote.response.SignUpResponse
import com.thejerryuc.grocerystore.domain.repositories.UserRepo
import com.thejerryuc.grocerystore.general.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class Register(private val userRepo: UserRepo) {
    operator fun invoke(request: SignUpRequest): Flow<Resource<SignUpResponse>> =
        flow {
            try {
                emit(Resource.Loading<SignUpResponse>())
                var response = userRepo.signup(request)
                emit(Resource.Success<SignUpResponse>(response))
            } catch (e: HttpException){

                emit(Resource.Error<SignUpResponse>(message = e.localizedMessage ?: "Something went wrong"))

            } catch (e: IOException){

                emit(
                    Resource.Error<SignUpResponse>(
                    message = e.localizedMessage
                        ?: ("Could not reach server, " + "please check your internet")

                ))
            } catch (e: Exception){

                emit(
                    Resource.Error<SignUpResponse>(
                    message = e.localizedMessage ?: "Something went wrong"
                ))

            }
        }
}