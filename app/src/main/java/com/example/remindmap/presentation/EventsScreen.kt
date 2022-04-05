package com.example.remindmap.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.remindmap.ui.theme.color4
import com.example.remindmap.ui.theme.horizon
import com.example.remindmap.ui.theme.lochinvar

@Composable
fun EventScreen(
){
    Scaffold(
        topBar = {
            EventsAppBar()
        },
        floatingActionButton = {
            AddEventFab()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

        }
    }
}

@Composable
fun EventsAppBar(){
    EventScreenTopBar(
        onSearchClicked = {

        }
    )
}

@Composable
fun EventScreenTopBar(
    onSearchClicked: () -> Unit
){
    TopAppBar(
        modifier = Modifier,
        backgroundColor = lochinvar,
        elevation = 0.5  .dp,
        title = {
            Text(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                text = "Events",
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
            )
        },
        actions = {
            EventsAppBarActions(onSearchClicked = onSearchClicked)
        }

    )


}

@Composable
fun EventsAppBarActions(
    onSearchClicked: () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
){
    IconButton(
        onClick = { onSearchClicked}
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Tasks",
            tint = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun AddEventFab(

){
    FloatingActionButton(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        backgroundColor = lochinvar
    ) {
     Icon(
         imageVector = Icons.Default.Add,
         contentDescription = "Add Button",
         tint = horizon,

     )
    }
}

@Composable
fun EventSearchBar(
searchText: String,
onTextChange: (String) -> Unit,
onClosePressed: () -> Unit,
onClearPressed: () -> Unit,
onSearchClicked: (String) -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = horizon
    ) {
        TextField(
            value = searchText,
            onValueChange = {
                onTextChange(it)
            }
        )
    }
}



@Preview
@Composable
fun eventScreentest(){
    EventScreenTopBar(
        onSearchClicked = {}
    )
}