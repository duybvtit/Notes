package com.example.noteapp.presentation.home

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.noteapp.app.components.IncludeTopAppBar

@Composable
fun AllNotesScreen(onHomeClick: () -> Unit) {
    Scaffold(topBar = {
        IncludeTopAppBar(title = "", onBackClick = { onHomeClick() })
    }) { paddingValues ->
        Text(text = "TEST")
    }
}