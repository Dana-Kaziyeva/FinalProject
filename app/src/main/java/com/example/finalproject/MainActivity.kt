package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalproject.ui.theme.FinalProjectTheme
import com.example.finalproject.ui.screens.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalProjectTheme {
               MainScreen()
                }
            }
        }
    }


@Preview
@Composable
fun FinalProjectPreview(){
    FinalProjectTheme {
        Surface {
            MainScreen()
        }
    }
}