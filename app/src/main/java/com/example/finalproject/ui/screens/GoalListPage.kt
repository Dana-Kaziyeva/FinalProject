package com.example.finalproject.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class GoalListPage {
    var t:String = "GOT"
    @Composable
    fun GoalListPageLayout(){
        Text(text = t, color = Color.Green, fontSize = 30.sp)
    }

    @Composable
    fun setT(a: String){
        t=a
    }
}