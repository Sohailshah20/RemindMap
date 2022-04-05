package com.example.remindmap

import android.view.Surface
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remindmap.ui.theme.horizon

@ExperimentalMaterialApi
@Composable
fun EventItem(
//    event : Event,
    location: String,
    title: String,
    description: String,
    onDeleteClck: () -> Unit,
    onEditClick: () -> Unit,
    onCardClick: () -> Unit

){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
        ,
        shape = RoundedCornerShape(4.dp),
        color = MaterialTheme.colors.background,
        elevation = 5.dp,
        onClick = onCardClick
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Location",
                    modifier = Modifier.weight(6f),
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
            Text(
                text = "Title",
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Description",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Normal,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

    }

}

@ExperimentalMaterialApi
@Preview()
@Composable
fun test1Prev(){
    EventItem(location = "Hyderabad",
        title = "App",
        description = "Ellippiisss",
        onDeleteClck = { /*TODO*/ },
        onEditClick = { /*TODO*/ }) {

    }
}



