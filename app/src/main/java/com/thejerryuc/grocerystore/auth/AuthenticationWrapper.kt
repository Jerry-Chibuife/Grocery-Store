package com.thejerryuc.grocerystore.auth

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.thejerryuc.grocerystore.auth.viewmodels.AuthViewModel
import com.thejerryuc.grocerystore.navigation.navhost.AuthenticationNavigationHost

@Composable
fun AuthenticationWrapper(
    viewModel: AuthViewModel
) {
    val navHostController = rememberNavController()
    AuthenticationNavigationHost(navHostController = navHostController, authViewModel = viewModel)
}