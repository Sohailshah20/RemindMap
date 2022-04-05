package com.example.remindmap

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SearchScreenViewModel : ViewModel(){

//    //observing state of searchbar text
//    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
//    val searchTextState: State<String> = _searchTextState

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

//    fun updateSearchTextState(newValue: String){
//        _searchTextState.value = newValue
//    }

    fun updateSearchQuery(query: String){
        _searchQuery.value = query
    }



}