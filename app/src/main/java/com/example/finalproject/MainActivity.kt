package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalproject.ui.theme.FinalProjectTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.ui.screens.WelcomePage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalProjectTheme {
                val navController = rememberNavController()
                NavHost(navController =  navController, startDestination = "WelcomePage") {
                    composable("WelcomePage") {
                        WelcomePage(
                            navigateToHomePage = { navController.navigate("HomePage") },
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun FinalProjectPreview(){
    FinalProjectTheme {
        Surface {
            WelcomePage(navigateToHomePage = { })
        }
    }
}