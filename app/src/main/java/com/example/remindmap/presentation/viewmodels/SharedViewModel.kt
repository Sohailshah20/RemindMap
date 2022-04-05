package com.example.remindmap.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remindmap.data.models.EventTask
import com.example.remindmap.repositories.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: EventRepository
) : ViewModel() {

    private val _allEvents = MutableStateFlow<List<EventTask>>(emptyList())
    val allEvents: StateFlow<List<EventTask>> = _allEvents



    fun getAllEvents(){
        viewModelScope.launch {
            repository.getAllEvents.collect{
                    _allEvents.value = it
            }
        }
    }

}