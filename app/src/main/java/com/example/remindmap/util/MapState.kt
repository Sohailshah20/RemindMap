package com.example.remindmap.util

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties

data class MapState(
    val  properties: MapProperties = MapProperties(
        isMyLocationEnabled = true,
        mapStyleOptions = MapStyleOptions(MapStyle.json)
    ),

)