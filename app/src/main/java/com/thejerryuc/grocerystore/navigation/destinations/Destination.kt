package com.thejerryuc.grocerystore.navigation.destinations

sealed class Destination(val name: String, val route: String){

    object LoginDestination: Destination(name = "login", route = "login")

    object SignUpDestination: Destination(name = "signup", route = "signup")

}
