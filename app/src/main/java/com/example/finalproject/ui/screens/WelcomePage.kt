package com.example.finalproject.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.R
import com.example.finalproject.ui.theme.MainBackgroundColor
import com.example.finalproject.ui.theme.Welcome_Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomePage(
    modifier: Modifier = Modifier,
    navigateToHomePage: () -> Unit,
){
    var userName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf(5) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MainBackgroundColor),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(40.dp))
        Row (modifier = Modifier.align(Alignment.CenterHorizontally)){
            Text(
                text = "Welcome to ",
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                color = Welcome_Color
            )
            Text(
                text = "DreamForge",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = Welcome_Color
            )
        }
        Image(
            painter = painterResource(R.drawable.plan_img),
            contentDescription = "plan image",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(260.dp)
                .height(180.dp),
        )
        Text(
            text = "Please fill the form to gain better user experience",
            fontSize = 16.sp,
            textAlign = TextAlign.Left,
            color = Welcome_Color,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(260.dp)
                .padding(top = 2.dp),
        )
        OutlinedTextField(
            label = { Text(stringResource(R.string.user_name)) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            ),
            value = userName,
            onValueChange = { userName = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) },
            ),
            modifier = Modifier
                .width(260.dp)
                .height(60.dp)
        )
        Text(
            text = "Choose your age",
            color = Welcome_Color,
            modifier = Modifier.align(Alignment.Start).width(260.dp).padding(start = 60.dp)
        )
        age = Slider()

        Button(
            onClick = { navigateToHomePage() },
            modifier= Modifier
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 4.dp,
                    shape = RoundedCornerShape(18.dp),
                    color = Color.Unspecified
                )
                .padding(end = 15.dp)
            ,
            colors = ButtonDefaults.buttonColors(containerColor = Welcome_Color)
        )
        {
            Text(
                text = "Get started",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .clickable(
                        onClick = { navigateToHomePage() }
                    ),
            )
        }
        Spacer(modifier = modifier.height(10.dp))
    }
}

@Composable
fun Slider(): Int {
    var sliderPosition by remember { mutableStateOf(5f) }
    Column(modifier = Modifier.width(260.dp)) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 96,
            valueRange = 5f..100f
        )
        Text(text = (Math.round(sliderPosition)).toString())
    }
    return Math.round(sliderPosition)
}
