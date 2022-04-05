package com.example.remindmap.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.remindmap.data.models.EventTask

@Database(entities = [EventTask::class], version = 1, exportSchema = false  )
abstract class EventsDatabase : RoomDatabase(){

        abstract fun eventDao(): EventsDao

}