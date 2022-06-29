package com.thejerryuc.grocerystore.auth.events

sealed class RegisterFormEvent {
    data class EnteredEmail(val value: String) : RegisterFormEvent()
    data class EnteredPassword(val value: String) : RegisterFormEvent()
    data class EnteredFirstName(val value: String) : RegisterFormEvent()
    data class EnteredLastName(val value: String) : RegisterFormEvent()
    data class FocusChange(val focusFieldName: String) : RegisterFormEvent()
}