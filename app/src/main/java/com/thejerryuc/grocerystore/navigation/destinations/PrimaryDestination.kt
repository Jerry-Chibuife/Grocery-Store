package com.thejerryuc.grocerystore.navigation.destinations

import com.thejerryuc.grocerystore.R

sealed class PrimaryDestination(
    val name: String,
    val startRoute: String,
    val rootRoute: String,
    val icon: Int
){
    object Store: PrimaryDestination (
        name = "store",
        startRoute = "store",
        rootRoute = "store_root",
        icon = R.drawable.store
    )

    object Cart: PrimaryDestination (
        name = "cart",
        startRoute = "cart",
        rootRoute = "cart_root",
        icon = R.drawable.cart
    )

    object Favourite: PrimaryDestination (
        name = "favourite",
        startRoute = "favourite",
        rootRoute = "favourite_root",
        icon = R.drawable.liked
    )

    object Profile: PrimaryDestination (
        name = "profile",
        startRoute = "profile",
        rootRoute = "profile_root",
        icon = R.drawable.profile
    )

    object Explore: PrimaryDestination (
        name = "explore",
        startRoute = "explore",
        rootRoute = "explore_root",
        icon = R.drawable.search
    )
}
