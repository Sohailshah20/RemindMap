package com.example.remindmap.navigation.navg_graph

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.remindmap.navigation.bottomBarNavGraph
import com.example.remindmap.navigation.screens.BottomBarScreens
import com.example.remindmap.navigation.screens.Screens
import com.example.remindmap.presentation.SearchScreen
import com.example.remindmap.util.Constants.ROOT_ROUTE

@ExperimentalFoundationApi
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.Home.route
    ) {

       bottomBarNavGraph(navController = navController)
        composable(route = Screens.SearchScreen.route){
            SearchScreen(navController = navController)
        }
    }
}