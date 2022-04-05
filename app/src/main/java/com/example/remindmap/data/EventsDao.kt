package com.example.remindmap.data

import androidx.room.*
import com.example.remindmap.data.models.EventTask
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDao {

    @Query("SELECT * FROM events_table ORDER BY id ASC")
    fun getAllEvents(): Flow<List<EventTask>>

    @Query("SELECT * FROM events_table WHERE id=:eventId")
    fun getSelectedEvent(eventId: Int): Flow<EventTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(eventTask: EventTask)

    @Update
    suspend fun updateEvent(eventTask: EventTask)

    @Delete
    suspend fun deleteEvent(eventTask: EventTask)

    @Query("DELETE FROM events_table")
    suspend fun deleteAllEvents()

    @Query("SELECT * FROM events_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery OR locationName LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<EventTask>>





}