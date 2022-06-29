package com.thejerryuc.grocerystore.auth.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.thejerryuc.grocerystore.auth.events.LoginFormEvent
import com.thejerryuc.grocerystore.auth.events.RegisterFormEvent
import com.thejerryuc.grocerystore.auth.state.LoginFormState
import com.thejerryuc.grocerystore.auth.state.RegisterFormState
import com.thejerryuc.grocerystore.general.utils.InputType
import com.thejerryuc.grocerystore.general.utils.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel(){
    private val _state = mutableStateOf(RegisterFormState())
    val state: State<RegisterFormState> = _state

    fun createEvent(event: RegisterFormEvent){
        onEvent(event)
    }

    private fun onEvent(event: RegisterFormEvent) {
        when(event) {
            is RegisterFormEvent.EnteredEmail -> {
                _state.value = state.value.copy( email = event.value )
            }
            is RegisterFormEvent.EnteredPassword -> {
                _state.value = state.value.copy( password = event.value )
            }
            is RegisterFormEvent.EnteredFirstName -> {
                _state.value = state.value.copy( firstName = event.value )
            }
            is RegisterFormEvent.EnteredLastName -> {
                _state.value = state.value.copy( lastName = event.value )
            }
            is RegisterFormEvent.FocusChange -> {
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

                    "firstName" -> {
                        val validity = Util.validateInput(
                            inputValue = state.value.firstName,
                            inputType = InputType.TEXT
                        )
                        val inputValid = validity.first
                        if(!inputValid) {
                            val errorMessage = validity.second
                            _state.value = state.value.copy(
                                firstnameValid = false,
                                firstNameErrorMessage = errorMessage,
                                formValid = false
                            )
                        }
                    }

                    "lastName" -> {
                        val validity = Util.validateInput(
                            inputValue = state.value.password,
                            inputType = InputType.PASSWORD
                        )
                        val inputValid = validity.first
                        if(!inputValid) {
                            val errorMessage = validity.second
                            _state.value = state.value.copy(
                                lastNameValid = false,
                                lastNameErrorMessage = errorMessage,
                                formValid = false
                            )
                        }
                    }
                }
            }
        }
    }
}