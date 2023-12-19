package com.example.finalproject.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.finalproject.ui.theme.MainBackgroundColor
import com.example.finalproject.ui.theme.Welcome_Color

class Profile {
    //    var img_url=""
    @SuppressLint("NotConstructor")
    @Composable
    fun Profile(
        modifier: Modifier = Modifier,
        renavigate: () -> Unit,
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MainBackgroundColor),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
                Card(
                    modifier = Modifier.size(150.dp),
                    shape = RectangleShape,
                    elevation = CardDefaults.cardElevation(8.dp),
                ) {
                    AsyncImage(
                        model = imageData().random(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Button(
                    onClick = {
                        renavigate()
                    },
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            shape = RoundedCornerShape(16.dp),
                            color = Color.Unspecified
                        )
                        .padding(end = 13.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Welcome_Color)
                ) {
                    Text(
                        text = "Change image",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    renavigate()
                                }
                            ),
                    )
                }

            }

        }
    }



