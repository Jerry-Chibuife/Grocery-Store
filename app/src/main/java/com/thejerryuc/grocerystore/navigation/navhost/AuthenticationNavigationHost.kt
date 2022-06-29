package com.thejerryuc.grocerystore.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thejerryuc.grocerystore.auth.screens.Login
import com.thejerryuc.grocerystore.auth.screens.Register
import com.thejerryuc.grocerystore.auth.viewmodels.AuthViewModel
import com.thejerryuc.grocerystore.navigation.destinations.Destination

@Composable
fun AuthenticationNavigationHost(
    navHostController : NavHostController,
    authViewModel: AuthViewModel
    ){

    NavHost(navController =  navHostController,
    startDestination = Destination.LoginDestination.route){
     composable(route = Destination.LoginDestination.route)   {
         Login(navController = navHostController, authViewModel = authViewModel)
     }
        composable(route = Destination.SignUpDestination.route)   {
            Register(navController = navHostController, authViewModel = authViewModel)
        }
    }
}