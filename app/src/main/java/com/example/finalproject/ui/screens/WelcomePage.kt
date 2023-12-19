package com.example.finalproject.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.R
import com.example.finalproject.ui.AppViewModelProvider
import com.example.finalproject.ui.items.user.UserEntryViewModel
import com.example.finalproject.ui.theme.MainBackgroundColor
import com.example.finalproject.ui.theme.Welcome_Color
import kotlinx.coroutines.launch

class WelcomePage {
    private var name: String ="Ainalaiyn"
//    private var age: Int = 5
    private var visited: Boolean = false

    fun getName(): String{
        return name
    }
//    fun getAge(): Int{
//        return age
//    }
    fun setName(n: String){
        name = n
    }
//    fun setAge(a: Int) {
//        age = a
//    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun WelcomePageLayout(
        modifier: Modifier = Modifier,
        navigateToHomePage: () -> Unit,
        viewModel: UserEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)
    ) {
        var userName by remember {
            mutableStateOf("")
        }
        val coroutineScope = rememberCoroutineScope()
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MainBackgroundColor),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Welcome to ",
                    fontSize = 22.sp,
                    fontStyle = FontStyle.Italic,
                    color = Welcome_Color
                )
                Text(
                    text = "DreamForge",
                    fontSize = 22.sp,
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
                    .width(240.dp)
                    .height(160.dp),
            )
//            Text(
//                text = "Please fill the form to gain better user experience",
//                fontSize = 14.sp,
//                textAlign = TextAlign.Left,
//                color = Welcome_Color,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .width(240.dp)
//                    .padding(top = 1.dp),
//            )
//            OutlinedTextField(
//                label = { Text(text = "User name") },
//                singleLine = true,
//                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
//                value = userName,
//                placeholder = { Text("Default name: Ainalaiyn") },
//                onValueChange = { userName = it },
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Done
//                ),
//                keyboardActions = KeyboardActions(
//                    onDone = {
//                        focusManager.clearFocus()
//                        if(userName.isNotEmpty())
//                            name = userName
//                    },
//
//                    ),
//                modifier = Modifier
//                    .width(240.dp)
//                    .height(60.dp)
//            )
//            Text(
//                text = "Choose your age",
//                fontSize = 14.sp,
//                color = Welcome_Color,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .width(240.dp),
//            )
//            age = slider()
            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveUser()
                    }
                    navigateToHomePage() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
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
                    text = "Get started",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable(
                            onClick = {
//                                visited = true
                                navigateToHomePage() }
                        ),
                )
            }
        }
    }



}
