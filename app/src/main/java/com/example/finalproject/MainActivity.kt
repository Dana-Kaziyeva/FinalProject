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
import com.example.finalproject.ui.screens.HomePage
import com.example.finalproject.ui.screens.WelcomePage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalProjectTheme {
                val navController = rememberNavController()
                val welcome = WelcomePage()
                val home = HomePage()
                NavHost(navController =  navController,
                    startDestination = when(welcome.getVisited()){
                        false  -> "WelcomePage"
                        else -> "HomePage"}){
                    composable("WelcomePage") {
                        welcome.WelcomePageLayout (
                            navigateToHomePage = { navController.navigate("HomePage") },
                        )
                    }
                    composable("HomePage") {
                        home.HomePageLayout(welcome)
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
            HomePage().HomePageLayout (welcome = WelcomePage())
        }
    }
}