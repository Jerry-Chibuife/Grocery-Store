package com.thejerryuc.grocerystore.auth.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thejerryuc.grocerystore.auth.events.AuthEvent
import com.thejerryuc.grocerystore.auth.state.AuthState
import com.thejerryuc.grocerystore.data.remote.request.LoginRequest
import com.thejerryuc.grocerystore.data.remote.request.SignUpRequest
import com.thejerryuc.grocerystore.domain.usecases.auth.AuthenticationUseCases
import com.thejerryuc.grocerystore.general.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(private val authUseCases: AuthenticationUseCases) : ViewModel() {
    private val _state = mutableStateOf(AuthState(isAuthenticated = false))
    val state: State<AuthState> = _state

    private val _eventFlow = MutableSharedFlow<AuthEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun createEvent(event: AuthEvent){
        onEvent(event)
    }

    private fun onEvent(event: AuthEvent) {
        when(event){
            is AuthEvent.Login -> {
                val request = LoginRequest( email = event.email, password = event.password)
                login(request = request)
            }
            is AuthEvent.Register -> {
                val request = SignUpRequest(email = event.email, password = event.password,
                    firstName = event.firstName, lastName = event.lastName)
                register(request = request)
            }
            else -> {}
        }
    }

    private fun register(request: SignUpRequest) {
        authUseCases.register(request = request)
            .onEach {
                when(it){
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true,
                            )
                    }
                    is Resource.Error -> {
                        val message = it.message ?: "An unexpected error occurred"
                        _state.value = state.value.copy(
                            isLoading = false,
                            errorOccurred = true,
                            errorMessage = message
                        )
                        _eventFlow.emit(AuthEvent.LoginFailure(message = message))
                    }
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            isAuthenticated = true
                        )
                        _eventFlow.emit(
                            AuthEvent.RegisterSuccess
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun login(request: LoginRequest){
        authUseCases.login(request = request)
            .onEach {
                when(it){
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true,

                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            errorOccurred = true,
                            errorMessage = it.message ?: "An unexpected error occurred"
                        )
                        //Todo(emit event)
                    }
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            AuthEvent.LoginSuccess
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }


}