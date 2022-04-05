package com.example.remindmap.navigation.screens

sealed class Screens(val route: String){

    object SearchScreen : Screens(route = "search_screen")

    object AddEventScreen : Screens(route = "add_event_screen")

    object MainScreen : Screens(route = "main_screen")
}