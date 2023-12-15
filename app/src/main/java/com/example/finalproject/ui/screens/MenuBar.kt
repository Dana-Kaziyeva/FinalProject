package com.example.finalproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finalproject.R
import com.example.finalproject.ui.theme.HomePage_Color

class MenuBar {

    @Composable
    fun BottomBar(modifier: Modifier = Modifier.fillMaxWidth()){
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth().height(60.dp)){
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.wish),
                    contentDescription = "wish",
                    modifier = Modifier.fillMaxSize(),
                    tint = HomePage_Color
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.goal),
                    contentDescription = "wish",
                    modifier = Modifier.fillMaxSize(),
                    tint = HomePage_Color
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = "wish",
                    modifier = Modifier.fillMaxSize(),
                    tint = HomePage_Color
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.list),
                    contentDescription = "wish",
                    modifier = Modifier.fillMaxSize(),
                    tint = HomePage_Color
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = "wish",
                    modifier = Modifier.fillMaxSize(),
                    tint = HomePage_Color

                )
            }

        }
    }


}

