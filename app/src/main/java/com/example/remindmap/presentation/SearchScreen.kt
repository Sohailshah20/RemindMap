package com.example.remindmap.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.remindmap.SearchScreenViewModel

@Composable
fun SearchScreen(
    navController: NavHostController,
){
    val searchScreenViewModel = SearchScreenViewModel()

    val searchQuery by searchScreenViewModel.searchQuery
    
    val scaffoldState = rememberScaffoldState()
    
    Scaffold(

    ) {
        SearchBar(searchText = searchQuery,
            onTextChange = {
                searchScreenViewModel.updateSearchQuery(query = it)
            },
            onBackPressed = {

            },
            onClearPressed = {

            },
            onSearchClicked = {

            }
        )
    }

}

@Composable
fun SearchBar(
    searchText: String,
    onTextChange: (String) -> Unit,
    onBackPressed: () -> Unit,
    onClearPressed: () -> Unit,
    onSearchClicked: (String) -> Unit

){

    val focusRequester = remember{ FocusRequester() }
    var showClearButton by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)

        ,
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            elevation = AppBarDefaults.TopAppBarElevation
        ) {
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                showClearButton = (focusState.isFocused)
            }
            .focusRequester(focusRequester),
            value = searchText,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = "Search Here")
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            maxLines = 1,
            leadingIcon = {
                AnimatedVisibility(
                    visible = showClearButton,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    IconButton(
                        onClick = { onBackPressed() }
                    ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            },
            trailingIcon = {
                AnimatedVisibility(
                    visible = showClearButton,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    IconButton(onClick = { onClearPressed() }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(searchText)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )


        )
    }
}

//    LaunchedEffect(Unit) {
//        focusRequester.requestFocus()
//    }
}

@Composable
@Preview
fun test1prev(){
    SearchBar(searchText = "",
        onTextChange = {},
        onBackPressed = { /*TODO*/ },
        onClearPressed = { /*TODO*/ },
        onSearchClicked = {} )
}
