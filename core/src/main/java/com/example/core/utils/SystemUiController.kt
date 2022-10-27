package com.example.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun SetUpSystemUi(systemUiController: SystemUiController, systemColor: Color){
    SideEffect {
        systemUiController.setSystemBarsColor(color = systemColor)
    }
}