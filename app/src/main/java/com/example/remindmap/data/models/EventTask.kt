package com.example.remindmap.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.remindmap.ui.theme.*
import com.example.remindmap.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class EventTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val locationName: String,
    val locationLatitude: String,
    val locationLongitude: String,
    val title: String,
    val description: String,
    val color: Int,

){

    companion object{
        val eventColors = listOf(mineralGreen, lochinvar,horizon, copperField,cashmere,softAmber,whiteSmoke)
    }

}
