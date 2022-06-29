package com.thejerryuc.grocerystore.auth.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.thejerryuc.grocerystore.auth.events.LoginFormEvent
import com.thejerryuc.grocerystore.auth.state.LoginFormState
import com.thejerryuc.grocerystore.general.utils.InputType
import com.thejerryuc.grocerystore.general.utils.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel(){
    private val _state = mutableStateOf(LoginFormState())
    val state: State<LoginFormState> = _state

    fun createEvent(event: LoginFormEvent){
        onEvent(event)
    }

    private fun onEvent(event: LoginFormEvent) {
        when(event) {
            is LoginFormEvent.EnteredEmail -> {
                _state.value = state.value.copy( email = event.value )
            }
            is LoginFormEvent.EnteredPassword -> {
                _state.value = state.value.copy( password = event.value )
            }
            is LoginFormEvent.FocusChange -> {
                when (event.focusFieldName){
                    "email" -> {
                        val validity = Util.validateInput( inputValue = state.value.email,
                                inputType = InputType.EMAIL
                            )
                        val inputValid = validity.first
                        if (!inputValid) {
                            val errorMessage = validity.second
                            _state.value = state.value.copy(
                                emailValid = false,
                                emailErrorMessage = errorMessage,
                                formValid = false
                            )
                        }
                    }

                    "password" -> {
                        val validity = Util.validateInput(
                            inputValue = state.value.password,
                            inputType = InputType.PASSWORD
                        )
                        val inputValid = validity.first
                        if(!inputValid) {
                            val errorMessage = validity.second
                            _state.value = state.value.copy(
                                passwordValid = false,
                                passwordErrorMessage = errorMessage,
                                formValid = false
                            )
                        }
                    }
                }
            }
        }
    }
}