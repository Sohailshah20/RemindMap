package com.example.remindmap.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.remindmap.util.Constants.SEARCH_ROUTE
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@Composable
fun HomeScreen(
    navController: NavHostController,
){
    val scaffoldState = rememberScaffoldState()
    val uiSettings = remember{
        MapUiSettings(zoomControlsEnabled = false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
    ) {

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            uiSettings = uiSettings,
            
        )
        HomeTopBar(
            onClicked = {
                Log.d(TAG, "HomeScreen: search_screen")
                navController.navigate(route = "search_screen")
            }
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeTopBar(
    onClicked: () -> Unit
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .offset(y = 12.dp)
                ,
        ) {
            Surface(
                modifier = Modifier
                    .clickable(onClick = onClicked)
                ,
                shape = RoundedCornerShape(8.dp),
                elevation = AppBarDefaults.TopAppBarElevation
            ) {
                TopAppBar(
                    title = {
                        Text(
                            modifier = Modifier
                                .alpha(ContentAlpha.medium)
                                ,
                            text = "Search Here",

                            )
                    },
                    backgroundColor = Color.White,
                    navigationIcon = {
                        IconButton(onClick = onClicked) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon"
                            )
                        }
                    }

                )
            }
        }
}




//@Preview
//@Composable
//fun testPreview1(){
//    HomeScreen(HonavController = nav)
//}