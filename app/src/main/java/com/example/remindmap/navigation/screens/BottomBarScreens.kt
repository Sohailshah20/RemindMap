package com.example.remindmap.navigation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FormatListBulleted
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon_filled: ImageVector,
    val icon_outlined: ImageVector
){
    object Home : BottomBarScreens(
        route = "Home",
        title = "Home",
        icon_filled = Icons.Filled.Home,
        icon_outlined = Icons.Outlined.Home
    )
    object Events : BottomBarScreens(
        route = "Events",
        title = "Events",
        icon_filled = Icons.Filled.FormatListBulleted,
        icon_outlined = Icons.Outlined.FormatListBulleted,
    )
    object Profile : BottomBarScreens(
        route = "Profile",
        title = "Profile",
        icon_filled = Icons.Filled.Person,
        icon_outlined = Icons.Outlined.Person,
    )
}
