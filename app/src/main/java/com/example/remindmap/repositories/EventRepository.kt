package com.example.remindmap.repositories

import androidx.room.Query
import com.example.remindmap.data.EventsDao
import com.example.remindmap.data.models.EventTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class EventRepository @Inject constructor(
    private val eventsDao: EventsDao
){
    val getAllEvents: Flow<List<EventTask>> = eventsDao.getAllEvents()

    fun getSelectedEvent(eventId: Int): Flow<EventTask>{
        return eventsDao.getSelectedEvent(eventId = eventId)
    }

    suspend fun addEvent(eventTask: EventTask){
        eventsDao.addEvent(eventTask = eventTask)
    }

    suspend fun updateEvent(eventTask: EventTask){
        eventsDao.updateEvent(eventTask = eventTask)
    }

    suspend fun deleteEvent(eventTask: EventTask){
        eventsDao.deleteEvent(eventTask = eventTask)
    }

    suspend fun deleteAllEvents(){
        eventsDao.deleteAllEvents()
    }

    fun searchDatabase(searchQuery: String): Flow<List<EventTask>>{
        return eventsDao.searchDatabase(searchQuery = searchQuery)
    }

}