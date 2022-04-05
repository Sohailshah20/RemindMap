package com.example.remindmap.navigation.navg_graph

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.remindmap.navigation.screens.BottomBarScreens

@ExperimentalFoundationApi
@Composable
fun MainScreen(

    //viewmodel
){
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomBar(navController = navController) }
    ) {
        NavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    val bottomBarColor = 0xFFF1F4FB
    val  screens = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Events,
        BottomBarScreens.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Color(bottomBarColor),
        contentColor = Color.Blue
    ) {
        screens.forEach{ screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreens,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    val selectedColor = 0xFF082253
    val unSelectedColor = 0xFF464749
    val selected =  currentDestination?.hierarchy?.any{
        it.route == screen.route
    } == true
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
                },
        icon = {
            Icon(
                if(selected) screen.icon_filled else screen.icon_outlined ,
                contentDescription = screen.title)
        },
        selected = selected,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
                restoreState = true
            }
        },
        selectedContentColor = Color(selectedColor),
        unselectedContentColor = Color(unSelectedColor)

    )
}