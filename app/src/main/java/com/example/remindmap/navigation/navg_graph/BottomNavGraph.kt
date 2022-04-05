package com.example.remindmap.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.remindmap.navigation.screens.BottomBarScreens
import com.example.remindmap.presentation.EventScreen
import com.example.remindmap.presentation.HomeScreen
import com.example.remindmap.presentation.ProfileScreen

fun NavGraphBuilder.bottomBarNavGraph(
    navController: NavHostController
){
    composable(route = BottomBarScreens.Home.route) {
        HomeScreen(navController = navController)
    }
    composable(route = BottomBarScreens.Events.route) {
        EventScreen()
    }
    composable(route = BottomBarScreens.Profile.route) {
        ProfileScreen()
    }
}