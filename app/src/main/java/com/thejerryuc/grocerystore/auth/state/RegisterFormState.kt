package com.thejerryuc.grocerystore.auth.state

data class RegisterFormState(
    val email: String ="",
    val emailValid: Boolean = true,
    val emailErrorMessage: String = "",
    val password: String = "",
    val passwordValid: Boolean = true,
    val passwordErrorMessage:String = "",
    val firstName: String ="",
    val firstnameValid:Boolean = true,
    val firstNameErrorMessage: String = "",
    val lastName: String = "",
    val lastNameValid: Boolean = true,
     val lastNameErrorMessage: String = "",
    val formValid: Boolean = true
)