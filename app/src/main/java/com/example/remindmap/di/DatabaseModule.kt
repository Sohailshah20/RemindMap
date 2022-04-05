package com.example.remindmap.di

import android.content.Context
import androidx.room.Room
import com.example.remindmap.data.EventsDatabase
import com.example.remindmap.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        EventsDatabase::class.java,
        DATABASE_NAME
    ).build()


    @Provides
    @Singleton
    fun providesDao(eventsDatabase: EventsDatabase) = eventsDatabase.eventDao()

}