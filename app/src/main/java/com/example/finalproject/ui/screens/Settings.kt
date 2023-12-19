package com.example.finalproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.ui.theme.MainBackgroundColor
import com.example.finalproject.ui.theme.Welcome_Color

//data class ImgUrl(var img_url:String ="")
//var LocalUrlHostState = compositionLocalOf { ImgUrl() }
@Composable
    fun Settings(
            modifier: Modifier = Modifier,
            navigateToProfile: () -> Unit,
        ) {
//    var img_url = LocalUrlHostState.current
    val focusManager = LocalFocusManager.current
//    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MainBackgroundColor),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Change your profile picture ",
            fontSize = 22.sp,
            fontStyle = FontStyle.Italic,
            color = Welcome_Color
        )
        var input by remember { mutableStateOf("") }
        OutlinedTextField(
            label = { Text(text = "Image url") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
            ),
            value = input,
            onValueChange = { input = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                },
            ),
            modifier = Modifier
                .width(240.dp)
                .height(60.dp)
        )
        Button(
            onClick = {
//                Profile().img_url = input
                navigateToProfile()
            },
            modifier = Modifier
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(16.dp),
                    color = Color.Unspecified
                )
                .padding(end = 13.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Welcome_Color)
        )
        {
            Text(
                text = "Change image",
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .clickable(
                        onClick = {
                            navigateToProfile()
                        }
                    ),
            )
        }


    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun loadImageURL(navigateToProfile: () -> Unit){
//    val focusManager = LocalFocusManager.current
//
//}